package com.mradhit.questskills.screens;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.managers.NetworkManager;
import com.mradhit.questskills.managers.ScreenManager;
import com.mradhit.questskills.managers.TextureManager;
import com.mradhit.questskills.managers.UnlockManager;
import com.mradhit.questskills.screens.painters.SpritePainters;
import com.mradhit.questskills.screens.templates.ButtonTemplate;
import com.mradhit.questskills.utils.Tuple;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

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

        Tuple<UnlockManager.PowerUp, List<String>> tekad_pendekar = getReqs(UnlockManager.PowerUps.TEKAD_PENDEKAR);
        powerups.add(new ButtonTemplate(texture.button(1), new String[]{"Tekad Pendekar"}, new Integer[]{45, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.PowerUp.$1);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(tekad_pendekar.x.isUnlocked()).setTooltip(tekad_pendekar.x.hasClaimed() + "Tekad Pendekar", "Karakter akan mendapatkan +3 Heart ketika membuka Jenis Power Ini", "",
                "Cara mendapatkannya:", tekad_pendekar.y.get(0), tekad_pendekar.y.get(1), tekad_pendekar.y.get(2)));


        Tuple<UnlockManager.PowerUp, List<String>> tekad_hati = getReqs(UnlockManager.PowerUps.TEKAD_HATI);
        powerups.add(new ButtonTemplate(texture.button(2), new String[]{"Tekad Hati"}, new Integer[]{63, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.PowerUp.$2);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.PowerUps.TEKAD_HATI)).setTooltip(tekad_hati.x.hasClaimed() + "Tekad Hati", "Karakter akan mendapatkan effect Fire immune dan mendapatkan +3 Heart.", "",
                "Cara mendapatkannya:", tekad_hati.y.get(0), tekad_hati.y.get(1), tekad_hati.y.get(2)));

        Tuple<UnlockManager.PowerUp, List<String>> tekad_raga_geni = getReqs(UnlockManager.PowerUps.TEKAD_RAGA_GENI);
        powerups.add(new ButtonTemplate(texture.button(3), new String[]{"Tekad Raga Geni"}, new Integer[]{81, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.PowerUp.$3);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.PowerUps.TEKAD_RAGA_GENI)).setTooltip(tekad_raga_geni.x.hasClaimed() + "Tekad Raga Geni", "Karakter mendapatkan Effect Strength 2, sehingga meningkatkan demage kepada musuh.", "karakter juga mendapatkan +4 Heart (nyawa tambahan)", "",
                "Cara mendapatkannya:", tekad_raga_geni.y.get(0), tekad_raga_geni.y.get(1), tekad_raga_geni.y.get(2), tekad_raga_geni.y.get(3)));

        Tuple<UnlockManager.PowerUp, List<String>> tekad_jiwa = getReqs(UnlockManager.PowerUps.TEKAD_JIWA);
        powerups.add(new ButtonTemplate(texture.button(4), new String[]{"Tekad Jiwa"}, new Integer[]{99, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.PowerUp.$4);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.PowerUps.TEKAD_JIWA)).setTooltip(tekad_jiwa.x.hasClaimed() + "Tekad Jiwa", "Karakter mendapatkan Block Power", "Mendapatakan Effect Absorption IV dan Resistance dan mendapatkan +5 Heart", "",
                "Cara mendapatkannya:", tekad_jiwa.y.get(0), tekad_jiwa.y.get(1), tekad_jiwa.y.get(2), tekad_jiwa.y.get(3)));

        Tuple<UnlockManager.PowerUp, List<String>> tekad_alam_semesta = getReqs(UnlockManager.PowerUps.TEKAD_ALAM_SEMESTA);
        powerups.add(new ButtonTemplate(texture.button(5), new String[]{"1"}, new Integer[]{117, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.PowerUp.$5);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.PowerUps.TEKAD_ALAM_SEMESTA)).setTooltip(tekad_alam_semesta.x.hasClaimed() + "Tekad Alam Semesta", "Tekad Alam semesta adalah tingkatan terakhir dari tahapan pendekar Wiro Sableng", "tekad ini adalah tingkatan paling sulit, namun dapat memberikan kekuatan yang luar biasa.", "",
                "Cara mendapatkannya:", tekad_alam_semesta.y.get(0), tekad_alam_semesta.y.get(1), tekad_alam_semesta.y.get(2), tekad_alam_semesta.y.get(3), tekad_alam_semesta.y.get(4)));

        for(ButtonTemplate button : powerups) {
            root.add(button, button.xPos, button.yPos, button.width, button.height);
        }
    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainters(texture.background(), resolution.width, resolution.height));
    }

    private static Tuple<UnlockManager.PowerUp, List<String>> getReqs(UnlockManager.PowerUps abilities) {
        UnlockManager.PowerUp eq = new UnlockManager.PowerUp(abilities);
        List<String> reqs = new ArrayList<>();

        for(UnlockManager.Requirement req : eq.getRequirements()) {
            reqs.add(UnlockManager.BooleanToColor(req.isUnlocked()) + req.getParsed());
        }

        return new Tuple<>(eq, reqs);
    }

    public static class isEnabled {
        public static boolean buttonEnabled(UnlockManager.PowerUps powerUps) {
            UnlockManager.PowerUp ret = new UnlockManager.PowerUp(powerUps);

            switch(powerUps) {
                case TEKAD_HATI -> {
                    UnlockManager.PowerUp powerup = new UnlockManager.PowerUp(UnlockManager.PowerUps.TEKAD_PENDEKAR);
                    if(!powerup.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
                case TEKAD_RAGA_GENI -> {
                    UnlockManager.PowerUp powerup = new UnlockManager.PowerUp(UnlockManager.PowerUps.TEKAD_HATI);
                    if(!powerup.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
                case TEKAD_JIWA -> {
                    UnlockManager.PowerUp powerup = new UnlockManager.PowerUp(UnlockManager.PowerUps.TEKAD_RAGA_GENI);
                    if(!powerup.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
                case TEKAD_ALAM_SEMESTA -> {
                    UnlockManager.PowerUp powerup = new UnlockManager.PowerUp(UnlockManager.PowerUps.TEKAD_JIWA);
                    if(!powerup.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
            }
            return false;
        }
    }
}
