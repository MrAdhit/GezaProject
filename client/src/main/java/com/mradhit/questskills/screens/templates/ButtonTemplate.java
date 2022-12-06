package com.mradhit.questskills.screens.templates;

import com.mradhit.questskills.managers.ScreenManager;
import com.mradhit.questskills.screens.widgets.WSpriteButton;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ButtonTemplate extends WSpriteButton {
    public int xPos;
    public int yPos;
    public int width;
    public int height;

    public ButtonTemplate(Identifier identifier, String[] tooltips, Integer[] p, Runnable onClick) {
        super(identifier);

        this.setTooltips(tooltips);
        this.setOnClick(onClick);

        ScreenManager.WH position = new ScreenManager.WH(p[0], p[1]).scaleMul(3).scaleDiv(MinecraftClient.getInstance().options.guiScale);
        ScreenManager.WH size = new ScreenManager.WH(p[2], p[3]).scaleMul(3).scaleDiv(MinecraftClient.getInstance().options.guiScale);

        this.xPos = position.width;
        this.yPos = position.height;
        this.width = size.width;
        this.height = size.height;
    }

    public ButtonTemplate enable(boolean enable) {
        this.setEnabled(enable);
        return this;
    }

    public ButtonTemplate setTooltip(String... tooltips) {
        List<String> list = new ArrayList<>();
        for(String tt : tooltips) {
            list.add(tt.replace('&', '§'));
        }
        this.setTooltips(list.toArray(String[]::new));
        return this;
    }
}
