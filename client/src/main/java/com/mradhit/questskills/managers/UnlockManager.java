package com.mradhit.questskills.managers;

import com.mradhit.questskills.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnlockManager {
    public static class Equipment {
        private final Equipments equipment;

        public Equipment(Equipments equipment) {
            this.equipment = equipment;
        }

        public boolean isUnlocked() {
            if(Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.Equipment.isEnabled + "-" + this.equipment.name().replace("_", "-").toLowerCase(), "false"))) return false;
            List<Boolean> unlocked = new ArrayList<>();

            for(Requirement req : this.getRequirements()) {
                unlocked.add(req.isUnlocked());
            }

            return !unlocked.contains(false);
        }

        public String hasClaimed() {
            if(Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.Equipment.isEnabled + "-" + this.equipment.name().replace("_", "-").toLowerCase(), "false"))) {
                return "&7";
            }

            return UnlockManager.BooleanToColor(this.isUnlocked());
        }

        public List<Requirement> getRequirements() {
            List<Requirement> ret = new ArrayList<>();
            switch(equipment) {
                case SEPATU_NAGA_GENI -> {
                    ret.add(new Requirement("Leather", "leather", 64, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Feather", "feather", 25, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Iron Ingot", "iron_ingot", 40, this.equipment, RequirementType.REQUIREMENT_ITEM));
                }
                case CELANA_NAGA_GENI -> {
                    ret.add(new Requirement("Diamond", "diamond", 5, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Skeleton", "skeleton", 20, this.equipment, RequirementType.REQUIREMENT_KILL));
                    ret.add(new Requirement("Zombie", "zombie", 20, this.equipment, RequirementType.REQUIREMENT_KILL));
                }
                case HELM_NAGA_GENI -> {
                    ret.add(new Requirement("Emerald", "emerald", 15, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Diamond", "diamond", 20, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Creeper", "creeper", 25, this.equipment, RequirementType.REQUIREMENT_KILL));
                }
                case ARMOR_NAGA_GENI -> {
                    ret.add(new Requirement("Netherite", "netherite_ingot", 4, this.equipment,  RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Block of Diamond", "diamond_block", 1, this.equipment,  RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Emerald", "emerald", 10, this.equipment,  RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Piglin", "piglin", 20, this.equipment, RequirementType.REQUIREMENT_KILL));
                }
                case KAPAK_NAGA_GENI -> {
                    ret.add(new Requirement("Iron Ingot", "iron_ingot", 64, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Block of Emerald", "emerald_block", 1, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Lava Bucket", "lava_bucket", 10, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Glowstone", "glowstone", 64, this.equipment, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Netherite", "netherite_ingot", 5, this.equipment, RequirementType.REQUIREMENT_ITEM));
                }
            }
            return ret;
        }
    }

    public static class PowerUp {
        private final PowerUps powerup;

        public PowerUp(PowerUps powerup) {
            this.powerup = powerup;
        }

        public boolean isUnlocked() {
            if(Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.PowerUP.isEnabled + "-" + this.powerup.name().replace("_", "-").toLowerCase(), "false"))) return false;
            List<Boolean> unlocked = new ArrayList<>();

            for(Requirement req : this.getRequirements()) {
                unlocked.add(req.isUnlocked());
            }

            return !unlocked.contains(false);
        }

        public String hasClaimed() {
            if(Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.PowerUP.isEnabled + "-" + this.powerup.name().replace("_", "-").toLowerCase(), "false"))) {
                return "&7";
            }

            return UnlockManager.BooleanToColor(this.isUnlocked());
        }

        public List<Requirement> getRequirements() {
            List<Requirement> ret = new ArrayList<>();
            switch(powerup) {
                case TEKAD_PENDEKAR -> {
                    ret.add(new Requirement("Golden Apple", "golden_apple", 10, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Redstone", "redstone", 128, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Healing Potion", "regeneration", 3, this.powerup, RequirementType.REQUIREMENT_CUSTOM));
                }
                case TEKAD_HATI -> {
                    ret.add(new Requirement("Magma Block", "magma_block", 64, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Lava Bucket", "lava_bucket", 10, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Magma Cream", "magma_cream", 15, this.powerup, RequirementType.REQUIREMENT_ITEM));
                }
                case TEKAD_RAGA_GENI -> {
                    ret.add(new Requirement("Blaze Powder", "blaze_powder", 15, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Diamond", "diamond", 15, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Gold Nugget", "gold_nugget", 25, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Wither Skeleton", "wither_skeleton", 128, this.powerup, RequirementType.REQUIREMENT_KILL));
                }
                case TEKAD_JIWA -> {
                    ret.add(new Requirement("Quartz", "quartz", 128, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Glowstone", "glowstone", 128, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Bone", "bone", 128, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Soul Sand", "soul_sand", 64, this.powerup, RequirementType.REQUIREMENT_ITEM));
                }
                case TEKAD_ALAM_SEMESTA -> {
                    ret.add(new Requirement("Heart of the sea", "heart_of_the_sea", 1, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Nether star", "nether_star", 1, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Dragon egg", "dragon_egg", 1, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Enchanted golden apple", "enchanted_golden_apple", 1, this.powerup, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Crying obsidian", "crying_obsidian", 15, this.powerup, RequirementType.REQUIREMENT_ITEM));
                }
            }
            return ret;
        }
    }

    public static class Ability {
        private final Abilities ability;

        public Ability(Abilities ability) {
            this.ability = ability;
        }

        public boolean isUnlocked() {
            if(Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.Ability.isEnabled + "-" + this.ability.name().replace("_", "-").toLowerCase(), "false"))) return false;
            List<Boolean> unlocked = new ArrayList<>();

            for(Requirement req : this.getRequirements()) {
                unlocked.add(req.isUnlocked());
            }

            return !unlocked.contains(false);
        }

        public String hasClaimed() {
            if(Boolean.parseBoolean((String) DataManager.data.getOrDefault(Constant.Structure.Ability.isEnabled + "-" + this.ability.name().replace("_", "-").toLowerCase(), "false"))) {
                return "&7";
            }

            return UnlockManager.BooleanToColor(this.isUnlocked());
        }

        public List<Requirement> getRequirements() {
            List<Requirement> ret = new ArrayList<>();
            switch(ability) {
                case SAYATAN_LISTRIK -> {
                    ret.add(new Requirement("Glowstone", "glowstone", 25, this.ability, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Zombie", "zombie", 25, this.ability, RequirementType.REQUIREMENT_KILL));
                    ret.add(new Requirement("Drowned", "drowned", 20, this.ability, RequirementType.REQUIREMENT_KILL));
                }
                case KAPAK_MELAYANG -> {
                    ret.add(new Requirement("Loyalty Enchantment Book", "loyalty", 1, this.ability, RequirementType.REQUIREMENT_CUSTOM));
                    ret.add(new Requirement("Chorus Fruit", "chorus_fruit", 64, this.ability, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Ender Pearl", "ender_pearl", 20, this.ability, RequirementType.REQUIREMENT_ITEM));
                }
                case AURA_SAKTI -> {
                    ret.add(new Requirement("Raw Rabbit", "rabbit", 20, this.ability, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Lapis Lazuli", "lapis_lazuli", 64, this.ability, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Glow Ink Sac", "glow_ink_sac", 20, this.ability, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Blaze", "blaze", 20, this.ability, RequirementType.REQUIREMENT_KILL));
                }
                case SERANGAN_PETIR_BERTUBI -> {
                    ret.add(new Requirement("Channeling Enchantment Book", "channeling", 1, this.ability, RequirementType.REQUIREMENT_CUSTOM));
                    ret.add(new Requirement("Slowness Potion", "slowness", 3, this.ability, RequirementType.REQUIREMENT_CUSTOM));
                    ret.add(new Requirement("Snowball", "snowball", 64 * 4, this.ability, RequirementType.REQUIREMENT_ITEM));
                }
                case AMUKAN_PENDEKAR_SAKTI -> {
                    ret.add(new Requirement("Elytra", "elytra", 1, this.ability, RequirementType.REQUIREMENT_ITEM));
                    ret.add(new Requirement("Shulker", "shulker", 5, this.ability, RequirementType.REQUIREMENT_KILL));
                    ret.add(new Requirement("Dragon", "ender_dragon", 1, this.ability, RequirementType.REQUIREMENT_KILL));
                }
            }
            return ret;
        }
    }

    public static class Requirement {
        private final String name;
        private final String identifier;
        private final int amount;
        private final Object equipment;
        private final RequirementType requirementType;

        public Requirement(String name, String identifier, int amount, Object equipment, RequirementType requirementType) {
            this.name = name;
            this.identifier = identifier;
            this.amount = amount;
            this.equipment = equipment;
            this.requirementType = requirementType;
        }

        public String getParsed() {
            return (this.requirementType.equals(RequirementType.REQUIREMENT_KILL) ? "Kill " : "") + "x" + this.amount + " " + this.name;
        }

        public boolean isUnlocked() {
            if(Boolean.parseBoolean((String) DataManager.data.getOrDefault("testingmode", "false"))) return true;

//            if(new Equipment((Equipments) this.equipment).isUnlocked()) return true;
            switch(this.requirementType) {
                case REQUIREMENT_ITEM -> {
                    HashMap<String, String> inventories = (HashMap<String, String>) DataManager.data.get("inventories");
                    return Integer.parseInt(inventories.getOrDefault(this.identifier.toUpperCase().replace(" ", "_"), "0")) >= this.amount;
                }
                case REQUIREMENT_KILL -> {
                    HashMap<String, String> kills = (HashMap<String, String>) DataManager.data.getOrDefault("killed-entity", new HashMap<String, String>());
                    return Integer.parseInt(kills.getOrDefault(this.identifier.toUpperCase(), "0")) >= this.amount;
                }
                case REQUIREMENT_CUSTOM -> {
                    HashMap<String, String> custom = (HashMap<String, String>) DataManager.data.getOrDefault("custom-data", new HashMap<String, String>());
                    return Integer.parseInt(custom.getOrDefault(this.identifier.toUpperCase(), "0")) >= this.amount;
                }
            }
            return false;
        }


    }

    public static String BooleanToColor(boolean bool) {
        return (bool ? "&a" : "&c");
    }

    public static enum RequirementType {
        REQUIREMENT_ITEM,
        REQUIREMENT_KILL,
        REQUIREMENT_CUSTOM
    }

    public static enum Equipments {
        SEPATU_NAGA_GENI,
        CELANA_NAGA_GENI,
        HELM_NAGA_GENI,
        ARMOR_NAGA_GENI,
        KAPAK_NAGA_GENI
    }

    public static enum Abilities {
        SAYATAN_LISTRIK,
        KAPAK_MELAYANG,
        AURA_SAKTI,
        SERANGAN_PETIR_BERTUBI,
        AMUKAN_PENDEKAR_SAKTI
    }

    public static enum PowerUps {
        TEKAD_PENDEKAR,
        TEKAD_HATI,
        TEKAD_RAGA_GENI,
        TEKAD_JIWA,
        TEKAD_ALAM_SEMESTA
    }
}
