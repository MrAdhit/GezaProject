package com.mradhit.questskills.managers;

import com.mradhit.questskills.QuestSkills;
import org.bukkit.entity.Player;

public class CommandManager {
    public CommandManager() {
        QuestSkills.plugin.getCommand("setdata").setExecutor((sender, command, label, args) -> {
            DataManager playerData = new DataManager((Player) sender);
            System.out.println(playerData.json);
            System.out.println(playerData.data);
            playerData.json.set(args[0], args[1]);
            sender.sendMessage("setting data to " + args[0] + " " + args[1]);
            return true;
        });
    }
}
