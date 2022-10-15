package com.mradhit.questskills;

import com.mradhit.questskills.utils.Identifier;

import java.util.logging.Logger;

public class Constant {
    public static class MOD {
        public final static String ID = "questskills";
        public final static String NAME = "Quest & Skills";
    }

    public static class PacketChannel {
        public final static Identifier SYNCHRONIZE = new Identifier(MOD.ID, "synchronize");

        public static class Equipment {
            public final static Identifier $1 = new Identifier(MOD.ID, "equipment/1");
            public final static Identifier $2 = new Identifier(MOD.ID, "equipment/2");
            public final static Identifier $3 = new Identifier(MOD.ID, "equipment/3");
            public final static Identifier $4 = new Identifier(MOD.ID, "equipment/4");
            public final static Identifier $5 = new Identifier(MOD.ID, "equipment/5");
        }

        public static class Ability {
            public final static Identifier $1 = new Identifier(MOD.ID, "ability/1");
            public final static Identifier $2 = new Identifier(MOD.ID, "ability/2");
            public final static Identifier $3 = new Identifier(MOD.ID, "ability/3");
            public final static Identifier $4 = new Identifier(MOD.ID, "ability/4");
            public final static Identifier $5 = new Identifier(MOD.ID, "ability/5");
        }

        public static class PowerUp {
            public final static Identifier $1 = new Identifier(MOD.ID, "powerup/1");
            public final static Identifier $2 = new Identifier(MOD.ID, "powerup/2");
            public final static Identifier $3 = new Identifier(MOD.ID, "powerup/3");
            public final static Identifier $4 = new Identifier(MOD.ID, "powerup/4");
            public final static Identifier $5 = new Identifier(MOD.ID, "powerup/5");
        }
    }

    public static class Structure {
        public static class Equipment {
            public final static String isEnabled = "equipment-enabled";
        }
        public static class Ability {
            public final static String isEnabled = "ability-enabled";
        }
        public static class PowerUP {
            public final static String isEnabled = "powerup-enabled";
        }
    }

    public final static Logger LOGGER = QuestSkills.plugin.getLogger();
}
