package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;
import net.minecraft.util.Identifier;

public class TextureManager {
    public static class Menu {
        private final TAB tab;

        public Menu(TAB tab) {
            this.tab = tab;
        }

        public Identifier button(int button_index) {
            return GetIdentifier("textures/gui/buttons/" + this.tab.name().toLowerCase() + "_" + button_index + ".png");
        }

        public Identifier background() {
            return GetIdentifier("textures/gui/backgrounds/" + this.tab.name().toLowerCase() + ".png");
        }
    }
    public static Identifier GetIdentifier(String path) {
        return new Identifier(Constant.MOD.ID, path);
    }

    public static enum TAB {
        MAIN_MENU,
        EQUIPMENT,
        POWER_UP,
        ABILITY
    }

    public static enum TYPE {
        BACKGROUND,
        BUTTON
    }
}
