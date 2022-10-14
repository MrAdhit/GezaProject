package com.mradhit.questskills.screens;

import com.mradhit.questskills.managers.ScreenManager;
import com.mradhit.questskills.managers.TextureManager;
import com.mradhit.questskills.screens.painters.SpritePainters;
import com.mradhit.questskills.screens.templates.ButtonTemplate;
import com.mradhit.questskills.screens.widgets.WSpriteButton;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class PowerUp extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final ScreenManager.WH resolution = new ScreenManager.WH(176, 80).scaleMul(3).scaleDiv(MinecraftClient.getInstance().options.guiScale);
    private final TextureManager.Menu texture = new TextureManager.Menu(TextureManager.TAB.POWER_UP);

    public PowerUp() {
        setRootPanel(root);
        root.setSize(resolution.width, resolution.height);

        List<ButtonTemplate> powerups = new ArrayList<>();

        powerups.add(new ButtonTemplate(texture.button(1), new String[]{"1"}, new Integer[]{45, 37, 14, 14}, () -> {

        }).enable(true));
        powerups.add(new ButtonTemplate(texture.button(2), new String[]{"1"}, new Integer[]{63, 37, 14, 14}, () -> {

        }).enable(true));
        powerups.add(new ButtonTemplate(texture.button(3), new String[]{"1"}, new Integer[]{81, 37, 14, 14}, () -> {

        }).enable(true));
        powerups.add(new ButtonTemplate(texture.button(4), new String[]{"1"}, new Integer[]{99, 37, 14, 14}, () -> {

        }).enable(true));
        powerups.add(new ButtonTemplate(texture.button(5), new String[]{"1"}, new Integer[]{117, 37, 14, 14}, () -> {

        }).enable(true));


        for(ButtonTemplate button : powerups) {
            root.add(button, button.xPos, button.yPos, button.width, button.height);
        }

    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainters(texture.background(), resolution.width, resolution.height));
    }
}
