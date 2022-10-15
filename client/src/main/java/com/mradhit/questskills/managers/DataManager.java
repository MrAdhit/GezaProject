package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import org.json.JSONObject;

import java.util.HashMap;

// TODO: DATA NETWORKING AND MANAGEMENT
public class DataManager {
    public static HashMap<String, Object> data = new HashMap<>();
    public DataManager() {
        ClientPlayNetworking.registerGlobalReceiver(Constant.PacketChannel.SYNCHRONIZE, (client, handler, buffer, responseSender) -> {
            String buffers = buffer.readString();
            JSONObject json = new JSONObject(buffers);
            System.out.println(json.toMap());
            data.putAll(json.toMap());
        });
    }

    public static <E> E get(String key, Class<E> as) {
        return as.cast(data.get(key));
    }

//    public static <T> void set(String key, T value) {
//
//    }
}
