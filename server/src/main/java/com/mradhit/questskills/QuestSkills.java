package com.mradhit.questskills;

import com.mradhit.questskills.managers.CommandManager;
import com.mradhit.questskills.managers.EventManager;
import com.mradhit.questskills.managers.NetworkManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class QuestSkills extends JavaPlugin {
    public static QuestSkills plugin;

    @Override
    public void onEnable() {
        plugin = this;

        new NetworkManager();
        new EventManager();
        new CommandManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
