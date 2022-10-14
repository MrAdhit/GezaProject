package com.mradhit.questskills.managers;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mradhit.questskills.Constant;
import com.mradhit.questskills.screens.Equipment;
import com.mradhit.questskills.screens.MainMenu;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommandSource;

public class CommandManager {
    public CommandManager() {
        Constant.LOGGER.info("Initializing Commands");

        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("opengui").then(ClientCommandManager.argument("menu", StringArgumentType.string()).suggests((context, builder) -> {
            for(TextureManager.TAB tab : TextureManager.TAB.values()) {
                builder.suggest(tab.name());
            }
            return builder.buildFuture();
        }).executes(context -> {
            String menu = context.getArgument("menu", String.class);
            System.out.println(TextureManager.TAB.valueOf(menu));
            switch (TextureManager.TAB.valueOf(menu)) {
                case MAIN_MENU -> {
                    MinecraftClient.getInstance().setScreen(new ScreenManager(new MainMenu()));
                }
                case EQUIPMENT -> {
                    MinecraftClient.getInstance().setScreen(new ScreenManager(new Equipment()));
                }
                case POWER_UP -> {

                }
                case ABILITY -> {

                }
            }
            return 0;
        })));
    }
}
