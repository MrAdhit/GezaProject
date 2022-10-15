package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.screens.MainMenu;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindManager {
    public KeybindManager() {
        Constant.LOGGER.info("Initializing Keybinds");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (KEYBIND.OPEN_MAIN_MENU.isPressed()) {
                client.setScreen(new ScreenManager(new MainMenu()));
            }
        });
    }

    public static class KEYBIND {
        public final static KeyBinding OPEN_MAIN_MENU = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Open Main Menu",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_APOSTROPHE,
                Constant.MOD.NAME
        ));
    }
}
