package com.mradhit.questskills.screens;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.managers.*;
import com.mradhit.questskills.screens.painters.SpritePainters;
import com.mradhit.questskills.screens.templates.ButtonTemplate;
import com.mradhit.questskills.screens.widgets.WSpriteButton;
import com.mradhit.questskills.utils.Tuple;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class Equipment extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final ScreenManager.WH resolution = new ScreenManager.WH(176, 80).scaleMul(3).scaleDiv(MinecraftClient.getInstance().options.guiScale);
    private final TextureManager.Menu texture = new TextureManager.Menu(TextureManager.TAB.EQUIPMENT);

    public Equipment() {
        setRootPanel(root);
        root.setSize(resolution.width, resolution.height);

        List<ButtonTemplate> equipments = new ArrayList<>();

        // Tombol Sepatu Naga Geni
        Tuple<UnlockManager.Equipment, List<String>> sepatu_naga_geni = getReqs(UnlockManager.Equipments.SEPATU_NAGA_GENI);
        equipments.add(new ButtonTemplate(texture.button(1), new String[]{"Sepatu Naga Geni"}, new Integer[]{45, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Equipment.$1);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(sepatu_naga_geni.x.isUnlocked()).setTooltip(sepatu_naga_geni.x.hasClaimed() + "Sepatu Naga Geni", "Mendapatkan Sepatu Naga Geni ke inventory", "",
                "Cara Mendapatkannya:", sepatu_naga_geni.y.get(0), sepatu_naga_geni.y.get(1), sepatu_naga_geni.y.get(2), "",
                "Efek Ketika Dipakai:", "- Movement Speed +2", "- Armor +5"));

        // Tombol Celana Naga Geni
        Tuple<UnlockManager.Equipment, List<String>> celana_naga_geni = getReqs(UnlockManager.Equipments.CELANA_NAGA_GENI);
        equipments.add(new ButtonTemplate(texture.button(2), new String[]{"Celana Naga Geni"}, new Integer[]{63, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Equipment.$2);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Equipments.CELANA_NAGA_GENI)).setTooltip(celana_naga_geni.x.hasClaimed() + "Celana Naga Geni", "Mendapatkan Celana Naga Geni ke inventory", "",
                "Cara Mendapatkannya:", celana_naga_geni.y.get(0), celana_naga_geni.y.get(1), celana_naga_geni.y.get(2), "",
                "Efek Ketika Dipakai:", "- Heart +2", "- Armor +8"));

        // Tombol Helm Naga Geni
        Tuple<UnlockManager.Equipment, List<String>> helm_naga_geni = getReqs(UnlockManager.Equipments.HELM_NAGA_GENI);
        equipments.add(new ButtonTemplate(texture.button(3), new String[]{"Helm Naga Geni"}, new Integer[]{81, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Equipment.$3);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Equipments.HELM_NAGA_GENI)).setTooltip(helm_naga_geni.x.hasClaimed() + "Helm Nage Geni", "Mendapatkan Helm Naga Geni ke inventory", "",
                "Cara Mendapatkannya:", helm_naga_geni.y.get(0), helm_naga_geni.y.get(1), helm_naga_geni.y.get(2), "",
                "Efek Ketika Dipakai:", "- Armor +6", "- Heart +3"));

        // Tombol Armor Naga Geni
        Tuple<UnlockManager.Equipment, List<String>> armor_naga_geni = getReqs(UnlockManager.Equipments.ARMOR_NAGA_GENI);
        equipments.add(new ButtonTemplate(texture.button(4), new String[]{"Armor Naga Geni"}, new Integer[]{99, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Equipment.$4);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Equipments.ARMOR_NAGA_GENI)).setTooltip(armor_naga_geni.x.hasClaimed() + "Armor Naga Geni", "Mendapatkan Armor Naga Geni", "",
                "Cara Mendapatkannya:", armor_naga_geni.y.get(0), armor_naga_geni.y.get(1), armor_naga_geni.y.get(2), armor_naga_geni.y.get(3), "",
                "Efek Ketika Dipakai:", "- Armor +10", "- Heart +5", "- Protection IV"));

        // Tombol Kapak Naga Geni
        Tuple<UnlockManager.Equipment, List<String>> kapak_naga_geni = getReqs(UnlockManager.Equipments.KAPAK_NAGA_GENI);
        equipments.add(new ButtonTemplate(texture.button(5), new String[]{"Kapak Naga Geni"}, new Integer[]{117, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Equipment.$5);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Equipments.KAPAK_NAGA_GENI)).setTooltip(kapak_naga_geni.x.hasClaimed() + "Kapak Naga Geni", "Mendapatkan Kapak Naga Geni", "",
                "Cara Mendapatkannya:", kapak_naga_geni.y.get(0), kapak_naga_geni.y.get(1), kapak_naga_geni.y.get(2), kapak_naga_geni.y.get(3), kapak_naga_geni.y.get(4), "",
                "Efek Ketika Dipakai:", "- Attack Damage +15", "- Sharpness IV", "- Fire Aspect", "- Mending"));

        for(ButtonTemplate button : equipments) {
            root.add((WSpriteButton)button, button.xPos, button.yPos, button.width, button.height);
        }
    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainters(texture.background(), resolution.width, resolution.height));
    }

    private static Tuple<UnlockManager.Equipment, List<String>> getReqs(UnlockManager.Equipments equipments) {
        UnlockManager.Equipment eq = new UnlockManager.Equipment(equipments);
        List<String> reqs = new ArrayList<>();

        for(UnlockManager.Requirement req : eq.getRequirements()) {
            reqs.add(UnlockManager.BooleanToColor(req.isUnlocked()) + req.getParsed());
        }

        return new Tuple<>(eq, reqs);
    }

    public static class isEnabled {
        public static boolean buttonEnabled(UnlockManager.Equipments equipments) {
            UnlockManager.Equipment eq = new UnlockManager.Equipment(equipments);

            switch(equipments) {
                case CELANA_NAGA_GENI -> {
                    UnlockManager.Equipment equipment = new UnlockManager.Equipment(UnlockManager.Equipments.SEPATU_NAGA_GENI);
                    if(!equipment.hasClaimed().equals("&7")) return false;

                    return eq.isUnlocked();
                }
                case HELM_NAGA_GENI -> {
                    UnlockManager.Equipment equipment = new UnlockManager.Equipment(UnlockManager.Equipments.CELANA_NAGA_GENI);
                    if(!equipment.hasClaimed().equals("&7")) return false;

                    return eq.isUnlocked();
                }
                case ARMOR_NAGA_GENI -> {
                    UnlockManager.Equipment equipment = new UnlockManager.Equipment(UnlockManager.Equipments.HELM_NAGA_GENI);
                    if(!equipment.hasClaimed().equals("&7")) return false;

                    return eq.isUnlocked();
                }
                case KAPAK_NAGA_GENI -> {
                    UnlockManager.Equipment equipment = new UnlockManager.Equipment(UnlockManager.Equipments.ARMOR_NAGA_GENI);
                    if(!equipment.hasClaimed().equals("&7")) return false;

                    return eq.isUnlocked();
                }
            }
            return false;
        }
    }
}
