package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.QuestSkills;
import com.mradhit.questskills.utils.Identifier;
import org.bukkit.Bukkit;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

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

            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$2, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$3, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$4, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.Equipment.$5, (channel, player, message) -> {

            });
        }

        private void Ability() {
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$1, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$2, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$3, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$4, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.Ability.$5, (channel, player, message) -> {

            });
        }

        private void PowerUp() {
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$1, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$2, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$3, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$4, (channel, player, message) -> {

            });
            RegisterIncomingPacket(Constant.PacketChannel.PowerUp.$5, (channel, player, message) -> {

            });
        }
    }

    private static void RegisterIncomingPacket(Identifier channel, PluginMessageListener listener) {
        Bukkit.getMessenger().registerIncomingPluginChannel(QuestSkills.plugin, channel.identifier, listener);
    }

    public static byte[] BuildMessage(String input) {
        ByteBuffer buf = ByteBuffer.allocate(input.length() + 1);
        buf.put((byte) input.length());
        buf.put(input.getBytes(StandardCharsets.UTF_8));
        return buf.array();
    }
}
