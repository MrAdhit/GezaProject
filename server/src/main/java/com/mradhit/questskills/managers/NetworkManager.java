package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.QuestSkills;
import com.mradhit.questskills.utils.Identifier;
import net.Indyuce.mmoitems.MMOItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class NetworkManager {
    public NetworkManager() {
        Bukkit.getMessenger().registerOutgoingPluginChannel(QuestSkills.plugin, Constant.PacketChannel.SYNCHRONIZE.identifier);

        new HandlePackets();
    }

    public static class HandlePackets {
        public HandlePackets() {
            Equipment();
            Ability();
            PowerUp();
        }

        private void Equipment() {
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$1, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "THOR_BOOTS"));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.LEATHER, 64);
                    put(Material.FEATHER, 25);
                    put(Material.IRON_INGOT, 40);
                }});

                playerData.json.set(Constant.Structure.Equipment.isEnabled + "-" + Constant.Equipments.SEPATU_NAGA_GENI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$2, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "THOR_LEGGINGS"));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.DIAMOND, 5);
                }});

                playerData.json.set(Constant.Structure.Equipment.isEnabled + "-" + Constant.Equipments.CELANA_NAGA_GENI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$3, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "THOR_HELMET"));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.EMERALD, 15);
                    put(Material.DIAMOND, 20);
                }});

                playerData.json.set(Constant.Structure.Equipment.isEnabled + "-" + Constant.Equipments.HELM_NAGA_GENI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$4, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("ARMOR"), "THOR_CHESTPLATE"));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.NETHERITE_INGOT, 4);
                    put(Material.DIAMOND_BLOCK, 1);
                    put(Material.EMERALD, 10);
                }});

                playerData.json.set(Constant.Structure.Equipment.isEnabled + "-" + Constant.Equipments.ARMOR_NAGA_GENI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$5, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "THOR_HAMMER_SHINY"));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.IRON_ORE, 64);
                    put(Material.EMERALD_BLOCK, 1);
                    put(Material.GLOWSTONE, 64);
                    put(Material.NETHERITE_INGOT, 5);
                }});
                RemoveItems(player, new HashMap<Material, Integer>(){{
                    put(Material.LAVA_BUCKET, 10);
                }});

                playerData.json.set(Constant.Structure.Equipment.isEnabled + "-" + Constant.Equipments.KAPAK_NAGA_GENI.name().replace("_", "-").toLowerCase(), "true");
                playerData.json.set(Constant.Structure.Ability.isEnabled, "true");
            });
        }

        private void Ability() {
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$1, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().forEach(itemStack -> {
                    if(Objects.isNull(itemStack)) return;
                    if(!itemStack.getItemMeta().hasCustomModelData()) return;

                    if(itemStack.getItemMeta().getCustomModelData() == 2008) {
                        player.getInventory().remove(itemStack);
                        player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "THOR_HAMMER_SHINY_1"));
                    }
                });

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.GLOWSTONE, 25);
                }});

                playerData.json.set("ability-stage", "1");
                playerData.json.set(Constant.Structure.Ability.isEnabled + "-" + Constant.Abilities.SAYATAN_LISTRIK.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$2, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().forEach(itemStack -> {
                    if(Objects.isNull(itemStack)) return;
                    if(!itemStack.getItemMeta().hasCustomModelData()) return;

                    if(itemStack.getItemMeta().getCustomModelData() == 2008) {
                        player.getInventory().remove(itemStack);
                        player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "THOR_HAMMER_SHINY_2"));
                    }
                });

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.CHORUS_FRUIT, 64);
                    put(Material.ENDER_PEARL, 20);
                }});

                player.getInventory().forEach(itemStack -> {
                    if(Objects.isNull(itemStack)) return;
                    if(!itemStack.getType().equals(Material.ENCHANTED_BOOK)) return;
                    EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta) itemStack.getItemMeta();

                    if(enchantmentStorageMeta.hasStoredEnchant(Enchantment.LOYALTY)) {
                        itemStack.setAmount(0);
                    }
                });

                playerData.json.set("ability-stage", "2");
                playerData.json.set(Constant.Structure.Ability.isEnabled + "-" + Constant.Abilities.KAPAK_MELAYANG.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$3, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().forEach(itemStack -> {
                    if(Objects.isNull(itemStack)) return;
                    if(!itemStack.getItemMeta().hasCustomModelData()) return;

                    if(itemStack.getItemMeta().getCustomModelData() == 2008) {
                        player.getInventory().remove(itemStack);
                        player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "THOR_HAMMER_SHINY_3"));
                    }
                });

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.RABBIT, 20);
                    put(Material.LAPIS_LAZULI, 64);
                    put(Material.GLOW_INK_SAC, 20);
                }});

                playerData.json.set("ability-stage", "3");
                playerData.json.set(Constant.Structure.Ability.isEnabled + "-" + Constant.Abilities.AURA_SAKTI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$4, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().forEach(itemStack -> {
                    if(Objects.isNull(itemStack)) return;
                    if(!itemStack.getItemMeta().hasCustomModelData()) return;

                    if(itemStack.getItemMeta().getCustomModelData() == 2008) {
                        player.getInventory().remove(itemStack);
                        player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "THOR_HAMMER_SHINY_4"));
                    }
                });

                for (int i = 0; i < 4; i++) {
                    SubstractItem(player, new HashMap<Material, Integer>(){{
                        put(Material.SNOWBALL, 64);
                    }});
                }

                player.getInventory().forEach(itemStack -> {
                    if(itemStack.getType().equals(Material.ENCHANTED_BOOK)) {
                        EnchantmentStorageMeta enchantmentStorageMeta = (EnchantmentStorageMeta) itemStack.getItemMeta();

                        if(enchantmentStorageMeta.hasStoredEnchant(Enchantment.LOYALTY)) {
                            itemStack.setAmount(0);
                        }
                    }
                });

                for (int i = 0; i < 3; i++) {
                    player.getInventory().forEach(itemStack -> {
                        if(Objects.isNull(itemStack)) return;
                        if(itemStack.getType().equals(Material.POTION)) {
                            PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();

                            if(potionMeta.getBasePotionData().getType().equals(PotionType.SLOWNESS)) {
                                itemStack.setAmount(0);
                            }
                        }
                    });
                }

                playerData.json.set("ability-stage", "4");
                playerData.json.set(Constant.Structure.Ability.isEnabled + "-" + Constant.Abilities.SERANGAN_PETIR_BERTUBI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$5, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                player.getInventory().forEach(itemStack -> {
                    if(Objects.isNull(itemStack)) return;
                    if(!itemStack.getItemMeta().hasCustomModelData()) return;

                    if(itemStack.getItemMeta().getCustomModelData() == 2008) {
                        player.getInventory().remove(itemStack);
                        player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "THOR_HAMMER_SHINY_5"));
                    }
                });

                RemoveItems(player, new HashMap<Material, Integer>(){{
                    put(Material.ELYTRA, 1);
                }});

                playerData.json.set("ability-stage", "5");
                playerData.json.set(Constant.Structure.Ability.isEnabled + "-" + Constant.Abilities.AMUKAN_PENDEKAR_SAKTI.name().replace("_", "-").toLowerCase(), "true");
                playerData.json.set(Constant.Structure.PowerUP.isEnabled, "true");
            });
        }

        private void PowerUp() {
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$1, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                AttributeInstance playerAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                playerAttribute.setBaseValue(playerAttribute.getBaseValue() + (3.0 * 2));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.GOLDEN_APPLE, 10);
                }});
                for (int i = 0; i < 3; i++) {
                    SubstractItem(player, new HashMap<Material, Integer>(){{
                        put(Material.REDSTONE, 64);
                    }});
                }
                for (int i = 0; i < 3; i++) {
                    player.getInventory().forEach(itemStack -> {
                        if(Objects.isNull(itemStack)) return;
                        if(itemStack.getType().equals(Material.POTION)) {
                            PotionMeta potionMeta = (PotionMeta) itemStack.getItemMeta();

                            if(potionMeta.getBasePotionData().getType().equals(PotionType.REGEN)) {
                                itemStack.setAmount(0);
                            }
                        }
                    });
                }

                playerData.json.set(Constant.Structure.PowerUP.isEnabled + "-" + Constant.PowerUps.TEKAD_PENDEKAR.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$2, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                AttributeInstance playerAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                playerAttribute.setBaseValue(playerAttribute.getBaseValue() + (3.0 * 2));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.MAGMA_BLOCK, 64);
                    put(Material.MAGMA_CREAM, 15);
                }});
                RemoveItems(player, new HashMap<Material, Integer>(){{
                    put(Material.LAVA_BUCKET, 10);
                }});

                playerData.json.set("effect-stage", "1");
                playerData.json.set(Constant.Structure.PowerUP.isEnabled + "-" + Constant.PowerUps.TEKAD_HATI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$3, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                AttributeInstance playerAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                playerAttribute.setBaseValue(playerAttribute.getBaseValue() + (4.0 * 2));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.BLAZE_POWDER, 15);
                    put(Material.DIAMOND, 15);
                    put(Material.GOLD_NUGGET, 25);
                }});

                playerData.json.set("effect-stage", "2");
                playerData.json.set(Constant.Structure.PowerUP.isEnabled + "-" + Constant.PowerUps.TEKAD_RAGA_GENI.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$4, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                AttributeInstance playerAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                playerAttribute.setBaseValue(playerAttribute.getBaseValue() + (5.0 * 2));

                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, Integer.MAX_VALUE, 3));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.BONE, 64);
                    put(Material.SOUL_SAND, 64);
                }});
                for (int i = 0; i < 2; i++) {
                    SubstractItem(player, new HashMap<Material, Integer>(){{
                        put(Material.QUARTZ, 64);
                        put(Material.GLOWSTONE, 64);
                    }});
                }

                playerData.json.set("effect-stage", "3");
                playerData.json.set(Constant.Structure.PowerUP.isEnabled + "-" + Constant.PowerUps.TEKAD_JIWA.name().replace("_", "-").toLowerCase(), "true");
            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$5, (channel, player, message) -> {
                DataManager playerData = new DataManager(player);

                AttributeInstance playerAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
                playerAttribute.setBaseValue(playerAttribute.getBaseValue() + (5.0 * 2));

                SubstractItem(player, new HashMap<Material, Integer>(){{
                    put(Material.HEART_OF_THE_SEA, 1);
                    put(Material.NETHER_STAR, 1);
                    put(Material.DRAGON_EGG, 1);
                    put(Material.ENCHANTED_GOLDEN_APPLE, 1);
                    put(Material.CRYING_OBSIDIAN, 15);
                }});

                playerData.json.set("effect-stage", "4");
                playerData.json.set(Constant.Structure.PowerUP.isEnabled + "-" + Constant.PowerUps.TEKAD_ALAM_SEMESTA.name().replace("_", "-").toLowerCase(), "true");
            });
        }
    }

    public static void SubstractItem(Player player, HashMap<Material, Integer> items) {
        ArrayList<Material> subItem = new ArrayList<>();

        player.getInventory().forEach(itemStack -> {
            if(Objects.isNull(itemStack)) return;
            if(items.containsKey(itemStack.getType())) {
                if(itemStack.getAmount() < items.get(itemStack.getType())) return;
                if(!subItem.contains(itemStack.getType())) {
                    itemStack.subtract(items.get(itemStack.getType()));
                    subItem.add(itemStack.getType());
                }
            }
        });
    }

    public static void RemoveItems(Player player, HashMap<Material, Integer> items) {
        player.getInventory().forEach(itemStack -> {
            if(Objects.isNull(itemStack)) return;
            if(items.containsKey(itemStack.getType())) {
                Integer amount = items.get(itemStack.getType());
                if(amount <= 0) return;

                itemStack.setAmount(0);

                items.put(itemStack.getType(), amount - 1);
            }
        });
    }

    private static void RegisterIncomingPacket(Identifier channel, PluginMessageListener listener) {
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestSkills.plugin, channel.identifier, listener);
    }

    public static byte[] BuildMessage(String input) {
        ByteBuffer buf = ByteBuffer.allocate(input.length() + 1);

        buf.put(input.getBytes());
        return buf.array();
    }
}

