package com.mradhit.questskills.screens;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.managers.DataManager;
import com.mradhit.questskills.managers.ScreenManager;
import com.mradhit.questskills.managers.TextureManager;
import com.mradhit.questskills.screens.painters.SpritePainters;
import com.mradhit.questskills.screens.templates.ButtonTemplate;
import com.mradhit.questskills.screens.widgets.WSpriteButton;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.client.MinecraftClient;

public class MainMenu extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final ScreenManager.WH resolution = new ScreenManager.WH(176, 80).scaleMul(3).scaleDiv(MinecraftClient.getInstance().options.guiScale);
    private final TextureManager.Menu texture = new TextureManager.Menu(TextureManager.TAB.MAIN_MENU);

    public MainMenu() {
        setRootPanel(root);
        root.setSize(resolution.width, resolution.height);
        // TODO: SYNC WITH ACTUAL DATA
        ButtonTemplate equipment = new ButtonTemplate(texture.button(1), new String[]{"Ke Equipment"}, new Integer[]{43, 35, 18, 18}, () -> {
            MinecraftClient.getInstance().setScreen(new ScreenManager(new Equipment()));
        });
        ButtonTemplate ability = new ButtonTemplate(texture.button(2), new String[]{"Ke Ability"}, new Integer[]{79, 35, 18, 18}, () -> {
            MinecraftClient.getInstance().setScreen(new ScreenManager(new Ability()));
        }).enable(isEnabled.Ability());
        ButtonTemplate power_up = new ButtonTemplate(texture.button(3), new String[]{"Ke Power Up"}, new Integer[]{115, 35, 18, 18}, () -> {
            MinecraftClient.getInstance().setScreen(new ScreenManager(new PowerUp()));
        }).enable(isEnabled.PowerUp());

        root.add(equipment, equipment.xPos, equipment.yPos, equipment.width, equipment.height);
        root.add(ability, ability.xPos, ability.yPos, ability.width, ability.height);
        root.add(power_up, power_up.xPos, power_up.yPos, power_up.width, power_up.height);
    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainters(texture.background(), resolution.width, resolution.height));
    }

    public static class isEnabled {
        public static boolean Ability() {
            return Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.Ability.isEnabled, "false"));
        }
        public static boolean PowerUp() {
            return Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.PowerUP.isEnabled, "false"));
        }
    }
}
