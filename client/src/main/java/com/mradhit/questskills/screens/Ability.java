package com.mradhit.questskills.screens;

import com.mradhit.questskills.Constant;
import com.mradhit.questskills.managers.*;
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

public class Ability extends LightweightGuiDescription {
    private final WPlainPanel root = new WPlainPanel();
    private final ScreenManager.WH resolution = new ScreenManager.WH(176, 80).scaleMul(3).scaleDiv(MinecraftClient.getInstance().options.guiScale);
    private final TextureManager.Menu texture = new TextureManager.Menu(TextureManager.TAB.ABILITY);

    public Ability() {
        setRootPanel(root);
        root.setSize(resolution.width, resolution.height);

        List<ButtonTemplate> abilities = new ArrayList<>();

        Tuple<UnlockManager.Ability, List<String>> sayatan_listrik = getReqs(UnlockManager.Abilities.SAYATAN_LISTRIK);
        abilities.add(new ButtonTemplate(texture.button(1), new String[]{"Sayatan Listrik"}, new Integer[]{45, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$1);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(sayatan_listrik.x.isUnlocked()).setTooltip(sayatan_listrik.x.hasClaimed() + "Sayatan Listrik", "Sayatan Listrik menambah damage", "pada undead mob menggunakan Kapak Naga Geni", "",
                "Cara Mendapatkannya:", sayatan_listrik.y.get(0), sayatan_listrik.y.get(1), sayatan_listrik.y.get(2)));

        Tuple<UnlockManager.Ability, List<String>> kapak_melayang = getReqs(UnlockManager.Abilities.KAPAK_MELAYANG);
        abilities.add(new ButtonTemplate(texture.button(2), new String[]{"Kapak Melayang"}, new Integer[]{63, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$2);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Abilities.KAPAK_MELAYANG)).setTooltip(kapak_melayang.x.hasClaimed() + "Kapak Melayang", "Kapak akan kembali ke pemiliknya setelah dilempar", "",
                "Cara Mendapatkannya:", kapak_melayang.y.get(0), kapak_melayang.y.get(1), kapak_melayang.y.get(2)));

        Tuple<UnlockManager.Ability, List<String>> aura_sakti = getReqs(UnlockManager.Abilities.AURA_SAKTI);
        abilities.add(new ButtonTemplate(texture.button(3), new String[]{"Aura Sakti"}, new Integer[]{81, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$3);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Abilities.AURA_SAKTI)).setTooltip(aura_sakti.x.hasClaimed() + "Aura Sakti", "Aura listrik yang mengelilingi", "tubuh dan memberikan", "movement speed II dan kekuatan lebih", "",
                "Cara Mendapatkannya:", aura_sakti.y.get(0), aura_sakti.y.get(1), aura_sakti.y.get(2), aura_sakti.y.get(3)));

        Tuple<UnlockManager.Ability, List<String>> serangan_petir_bertubi = getReqs(UnlockManager.Abilities.SERANGAN_PETIR_BERTUBI);
        abilities.add(new ButtonTemplate(texture.button(4), new String[]{"Serangan Petir Bertubi"}, new Integer[]{99, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$4);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Abilities.SERANGAN_PETIR_BERTUBI)).setTooltip(serangan_petir_bertubi.x.hasClaimed() + "Serangan Petir Bertubi", "Serangan petir bertubi-tubi", "dengan damage yang sakit dan efek stun", "",
                "Cara Mendapatkannya:", serangan_petir_bertubi.y.get(0), serangan_petir_bertubi.y.get(1), serangan_petir_bertubi.y.get(2)));

        Tuple<UnlockManager.Ability, List<String>> amukan_pendekar_sakti = getReqs(UnlockManager.Abilities.AMUKAN_PENDEKAR_SAKTI);
        abilities.add(new ButtonTemplate(texture.button(5), new String[]{"Amukan Pendekar Sakti"}, new Integer[]{117, 37, 14, 14}, () -> {
            NetworkManager.SendEmpty(Constant.PacketChannel.Ability.$5);
            MinecraftClient.getInstance().player.playSound(new SoundEvent(new Identifier("ui.toast.challenge_complete")), 1, 1);
            MinecraftClient.getInstance().currentScreen.close();
        }).enable(isEnabled.buttonEnabled(UnlockManager.Abilities.AMUKAN_PENDEKAR_SAKTI)).setTooltip(amukan_pendekar_sakti.x.hasClaimed() + "Amukan Pendekar Sakti", "Mengeluarkan serangan elemen", "petir acak dan damage area sekitar", "",
                "Cara Mendapatkannya:", amukan_pendekar_sakti.y.get(0), amukan_pendekar_sakti.y.get(1), amukan_pendekar_sakti.y.get(2)));

        for(ButtonTemplate button : abilities) {
            root.add(button, button.xPos, button.yPos, button.width, button.height);
        }
    }

    @Override
    public void addPainters() {
        this.rootPanel.setBackgroundPainter(new SpritePainters(texture.background(), resolution.width, resolution.height));
    }

    private static Tuple<UnlockManager.Ability, List<String>> getReqs(UnlockManager.Abilities abilities) {
        UnlockManager.Ability eq = new UnlockManager.Ability(abilities);
        List<String> reqs = new ArrayList<>();

        for(UnlockManager.Requirement req : eq.getRequirements()) {
            reqs.add(UnlockManager.BooleanToColor(req.isUnlocked()) + req.getParsed());
        }

        return new Tuple<>(eq, reqs);
    }

    public static class isEnabled {
        public static boolean buttonEnabled(UnlockManager.Abilities abilities) {
            UnlockManager.Ability ret = new UnlockManager.Ability(abilities);

            switch(abilities) {
                case KAPAK_MELAYANG -> {
                    UnlockManager.Ability ability = new UnlockManager.Ability(UnlockManager.Abilities.SAYATAN_LISTRIK);
                    if(!ability.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
                case AURA_SAKTI -> {
                    UnlockManager.Ability ability = new UnlockManager.Ability(UnlockManager.Abilities.KAPAK_MELAYANG);
                    if(!ability.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
                case SERANGAN_PETIR_BERTUBI -> {
                    UnlockManager.Ability ability = new UnlockManager.Ability(UnlockManager.Abilities.AURA_SAKTI);
                    if(!ability.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
                case AMUKAN_PENDEKAR_SAKTI -> {
                    UnlockManager.Ability ability = new UnlockManager.Ability(UnlockManager.Abilities.SERANGAN_PETIR_BERTUBI);
                    if(!ability.hasClaimed().equals("&7")) return false;

                    return ret.isUnlocked();
                }
            }
            return false;
        }
    }
}
