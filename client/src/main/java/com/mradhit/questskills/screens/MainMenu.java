package com.mradhit.questskills.screens;

import com.mradhit.questskills.managers.ScreenManager;
import com.mradhit.questskills.managers.TextureManager;
import com.mradhit.questskills.screens.painters.SpritePainters;
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
    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainters(texture.background(), resolution.width, resolution.height));
    }
}
