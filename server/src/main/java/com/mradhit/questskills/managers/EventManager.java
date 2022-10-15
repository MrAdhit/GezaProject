package com.mradhit.questskills.managers;

import com.mradhit.questskills.QuestSkills;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;

public class EventManager implements Listener {
    public EventManager() {
        QuestSkills.plugin.getServer().getPluginManager().registerEvents(this, QuestSkills.plugin);
    }

    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent event) {
        BukkitTask task = Bukkit.getScheduler().runTaskTimerAsynchronously(QuestSkills.plugin, () -> {
            DataManager player_data = new DataManager(event.getPlayer());
            player_data.syncronize();
        }, 1L, 1L);

        DataManager.playerScheduler.put(event.getPlayer(), task);
    }

    @EventHandler
    private void OnPlayerQuit(PlayerQuitEvent event) {
        DataManager.playerScheduler.get(event.getPlayer()).cancel();
    }
}
