package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.QuestSkills;
import de.leonhard.storage.Json;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class DataManager {
    public static HashMap<Player, BukkitTask[]> playerScheduler = new HashMap<>();

    public HashMap<String, Object> data = new HashMap<>();
    public Player player;
    Json json;

    public DataManager(Player player) {
        this.player = player;
        this.json = new Json(player.getName(), "plugins/QuestSkills/");
        this.data.putAll(json.getData());
    }

    public void syncronize() {
        JSONObject data = new JSONObject();
        data.putAll(this.data);

        this.player.sendPluginMessage(QuestSkills.plugin, Constant.PacketChannel.SYNCHRONIZE.identifier, NetworkManager.BuildMessage(data.toJSONString()));
    }

    public <E> E get(String key, Class<E> as) {
        return as.cast(this.data.get(key));
    }

    public <T> void set(String key, T value) {
        this.data.put(key, value);
        this.json.putAll(this.data);
    }
}
