package com.mradhit.questskills.screens;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.managers.DataManager;
import com.mradhit.questskills.managers.NetworkManager;
import com.mradhit.questskills.managers.ScreenManager;
import com.mradhit.questskills.managers.TextureManager;
import com.mradhit.questskills.screens.painters.SpritePainters;
import com.mradhit.questskills.screens.templates.ButtonTemplate;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class Ability extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final ScreenManager.WH resolution = new ScreenManager.WH(176, 80).scaleMul(3).scaleDiv(MinecraftClient.getInstance().options.guiScale);
    private final TextureManager.Menu texture = new TextureManager.Menu(TextureManager.TAB.ABILITY);

    public Ability() {
        setRootPanel(root);
        root.setSize(resolution.width, resolution.height);

        List<ButtonTemplate> abilities = new ArrayList<>();

        abilities.add(new ButtonTemplate(texture.button(1), new String[]{"1"}, new Integer[]{45, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$1);
        }).enable(isEnabled.buttonEnabled(1)));
        abilities.add(new ButtonTemplate(texture.button(2), new String[]{"1"}, new Integer[]{63, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$2);
        }).enable(isEnabled.buttonEnabled(2)));
        abilities.add(new ButtonTemplate(texture.button(3), new String[]{"1"}, new Integer[]{81, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$3);
        }).enable(isEnabled.buttonEnabled(3)));
        abilities.add(new ButtonTemplate(texture.button(4), new String[]{"1"}, new Integer[]{99, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$4);
        }).enable(isEnabled.buttonEnabled(4)));
        abilities.add(new ButtonTemplate(texture.button(5), new String[]{"1"}, new Integer[]{117, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$5);
        }).enable(isEnabled.buttonEnabled(5)));

        for(ButtonTemplate button : abilities) {
            root.add(button, button.xPos, button.yPos, button.width, button.height);
        }
    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainters(texture.background(), resolution.width, resolution.height));
    }

    public static class isEnabled {
        public static boolean buttonEnabled(int index) {
            return Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.Ability.isEnabled + "-" + index, "false"));
        }
    }
}
