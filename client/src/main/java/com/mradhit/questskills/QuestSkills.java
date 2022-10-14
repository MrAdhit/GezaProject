package com.mradhit.questskills;

import com.mradhit.questskills.managers.CommandManager;
import com.mradhit.questskills.managers.KeybindManager;
import net.fabricmc.api.ModInitializer;

public class QuestSkills implements ModInitializer {

    @Override
    public void onInitialize() {
        Constant.LOGGER.info(String.format("Initializing %s", Constant.MOD.NAME));

        new KeybindManager();
        new CommandManager();
    }
}
