package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class DataManager {
    public static HashMap<String, Object> data = new HashMap<>();
    public DataManager() {
        ClientPlayNetworking.registerGlobalReceiver(Constant.PacketChannel.SYNCHRONIZE, (client, handler, buffer, responseSender) -> {
            String buffers = buffer.toString(StandardCharsets.UTF_8);
            JSONObject json = new JSONObject(buffers);

            data = (HashMap<String, Object>) json.toMap();
        });
    }

    public static <E> E get(String key, Class<E> as) {
        return as.cast(data.get(key));
    }
}
