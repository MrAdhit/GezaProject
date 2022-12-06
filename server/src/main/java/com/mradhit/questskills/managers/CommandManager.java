package com.mradhit.questskills.managers;

import com.mradhit.questskills.QuestSkills;
import net.Indyuce.mmoitems.MMOItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CommandManager {
    public CommandManager() {
        QuestSkills.plugin.getCommand("givemakapak").setExecutor((sender, command, label, args) -> {
            if(args.length < 1) return false;
            Player player = Bukkit.getPlayer(args[0]);

            if(Objects.nonNull(player)) {
                DataManager playerData = new DataManager(player);

                if(!playerData.json.contains("ability-stage")) return true;

                player.getInventory().forEach(itemStack -> {
                    if(Objects.isNull(itemStack)) return;
                    if(!itemStack.getItemMeta().hasCustomModelData()) return;

                    if(itemStack.getItemMeta().getCustomModelData() == 2008) {
                        player.getInventory().remove(itemStack);
                        player.getInventory().addItem(MMOItems.plugin.getItem(MMOItems.plugin.getTypes().get("SWORD"), "THOR_HAMMER_SHINY_" + playerData.json.get("ability-stage")));
                    }
                });
            }
            return true;
        });

        QuestSkills.plugin.getCommand("setdata").setExecutor((sender, command, label, args) -> {
            if(sender instanceof Player) {
                DataManager playerData = new DataManager((Player) sender);
                System.out.println(playerData.json);
                System.out.println(playerData.data);
                playerData.json.set(args[0], args[1]);
                sender.sendMessage("setting data to " + args[0] + " " + args[1]);
            }
            return true;
        });
    }
}
