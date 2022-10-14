package com.mradhit.questskills.managers;

import io.github.cottonmc.cotton.gui.GuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

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

        public WH scaleMul(int scaling) {
            this.width = this.width * scaling;
            this.height = this.height * scaling;
            return this;
        }

        public WH scaleDiv(int scaling) {
            if(scaling == 0) return this;
            this.width = this.width / scaling;
            this.height = this.height / scaling;
            return this;
        }
    }
}
