package com.mradhit.questskills.managers;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

import java.util.ArrayList;

public class ScreenManager extends CottonClientScreen {
    public ScreenManager(GuiDescription description) {
        super(description);
    }

    public static class WH {
        public int width;
        public int height;

        public WH(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
