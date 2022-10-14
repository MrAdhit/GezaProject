package com.mradhit.questskills.screens;

import com.mradhit.questskills.managers.ScreenManager;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;

public class MainMenu extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final ScreenManager.WH resolution = new ScreenManager.WH(100, 100);

    public MainMenu() {
        setRootPanel(root);
        root.setSize(resolution.width, resolution.height);
    }
}
