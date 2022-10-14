package com.mradhit.questskills;

import net.fabricmc.api.ModInitializer;

public class QuestSkills implements ModInitializer {

    @Override
    public void onInitialize() {
        Constant.LOGGER.info(String.format("Initializing %s", Constant.MOD.NAME));
    }
}
