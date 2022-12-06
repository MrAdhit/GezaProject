package com.mradhit.questskills.managers;

import com.mradhit.questskills.QuestSkills;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class EventManager implements Listener {
    public EventManager() {
        QuestSkills.plugin.getServer().getPluginManager().registerEvents(this, QuestSkills.plugin);
    }

    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent event) {
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(QuestSkills.plugin, () -> {
            Player player = event.getPlayer();
            DataManager playerData = new DataManager(player);
            JSONObject inventories = new JSONObject();
            JSONObject customData = new JSONObject();

            for(ItemStack item : player.getInventory().getContents()) {
                if(!Objects.isNull(item)) {
                    for(int i = 0; i < item.getAmount(); i++) {
                        if(item.getType().equals(Material.ENCHANTED_BOOK)) {
                            EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta) item.getItemMeta();

                            if(enchantmentStorageMeta.hasStoredEnchant(Enchantment.LOYALTY)) {
                                customData.put("LOYALTY", String.valueOf(Integer.parseInt((String) customData.getOrDefault("LOYALTY", "0")) + 1));
                            }
                            if(enchantmentStorageMeta.hasStoredEnchant(Enchantment.CHANNELING)) {
                                customData.put("CHANNELING", String.valueOf(Integer.parseInt((String) customData.getOrDefault("CHANNELING", "0")) + 1));
                            }
                        }
                        if(item.getType().equals(Material.POTION)) {
                            PotionMeta potionMeta = (PotionMeta) item.getItemMeta();

                            customData.put(potionMeta.getBasePotionData().getType().toString(), String.valueOf(Integer.parseInt((String) customData.getOrDefault(potionMeta.getBasePotionData().getType().toString(), "0")) + 1));
                        }
                        inventories.put(item.getType().name(), String.valueOf(Integer.parseInt((String) inventories.getOrDefault(item.getType().name(), "0")) + 1));
                    }
                }
            }

            switch (playerData.json.getOrDefault("effect-stage", "0")) {
                case "1": {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
                }
                case "2": {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                }
                case "3": {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
                }
                case "4": {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, Integer.MAX_VALUE, 0));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, Integer.MAX_VALUE, 0));
                }
            }

            playerData.json.set("custom-data", customData);
            playerData.json.set("inventories", inventories);
            playerData.syncronize();
        }, 20L, 20L);

        DataManager.playerScheduler.put(event.getPlayer(), new BukkitTask[]{task});
    }

    @EventHandler
    private void OnPlayerQuit(PlayerQuitEvent event) {
        for (BukkitTask task : DataManager.playerScheduler.get(event.getPlayer())) {
            task.cancel();
        }
    }

    @EventHandler
    private void OnItemPickup(EntityPickupItemEvent event) {

    }

    @EventHandler
    private void OnItemDrop(EntityDropItemEvent event) {

    }

    @EventHandler
    private void OnEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if(Objects.isNull(killer)) return;

        DataManager playerData = new DataManager(killer);
        JSONObject killedEntities = new JSONObject();
        killedEntities.putAll(playerData.json.getOrDefault("killed-entity", new HashMap()));
        killedEntities.put(entity.getType().name(), String.valueOf(Integer.parseInt((String) killedEntities.getOrDefault(entity.getType().name(), "0")) + 1));

        playerData.json.set("killed-entity", killedEntities);
    }
}
