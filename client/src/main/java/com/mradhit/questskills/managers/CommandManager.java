package com.mradhit.questskills.managers;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mradhit.questskills.Constant;
import com.mradhit.questskills.screens.Ability;
import com.mradhit.questskills.screens.Equipment;
import com.mradhit.questskills.screens.MainMenu;
import com.mradhit.questskills.screens.PowerUp;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.UUID;

public class CommandManager {
    public CommandManager() {
        Constant.LOGGER.info("Initializing Commands");

        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("mydata").then(ClientCommandManager.argument("data", StringArgumentType.string()).executes(context -> {
            String argument = context.getArgument("data", String.class);
            String data = DataManager.get(argument, String.class);

            context.getSource().getPlayer().sendSystemMessage(Text.of(data), UUID.randomUUID());

            return 0;
        })));

        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("getdata").executes(context -> {
            context.getSource().getPlayer().sendSystemMessage(Text.of(DataManager.data.toString()), UUID.randomUUID());

            return 0;
        }));

        ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("opengui").then(ClientCommandManager.argument("menu", StringArgumentType.string()).suggests((context, builder) -> {
            for(TextureManager.TAB tab : TextureManager.TAB.values()) {
                builder.suggest(tab.name());
            }
            return builder.buildFuture();
        }).executes(context -> {
            String menu = context.getArgument("menu", String.class);
            MinecraftClient client = context.getSource().getClient();

            switch (TextureManager.TAB.valueOf(menu)) {
                case MAIN_MENU -> client.send(() -> client.setScreen(new ScreenManager(new MainMenu())));
                case EQUIPMENT -> client.send(() -> client.setScreen(new ScreenManager(new Equipment())));
                case POWER_UP -> client.send(() -> client.setScreen(new ScreenManager(new PowerUp())));
                case ABILITY -> client.send(() -> client.setScreen(new ScreenManager(new Ability())));
            }
            return 0;
        })));
    }
}
