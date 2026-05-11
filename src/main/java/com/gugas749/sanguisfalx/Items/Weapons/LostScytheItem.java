package com.gugas749.sanguisfalx.Items.Weapons;

import com.gugas749.sanguisfalx.Utils.SFRarities;
import com.gugas749.sanguisfalx.Utils.SFWeaponsTiers;
import com.gugas749.sanguisfalx.Utils.SanguisScytheItem;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import team.lodestar.lodestone.systems.item.LodestoneItemProperties;

import java.util.List;

public class LostScytheItem extends SanguisScytheItem {

    private static final int DAMAGE_BONUS = 6;
    private static final float ATTACK_SPEED = 0.4F;
    // ────────────────────────────────────────────────────────────────────────

    public LostScytheItem() {
        super(
                SFWeaponsTiers.SANGUIS,
                DAMAGE_BONUS,
                ATTACK_SPEED,
                8.0f,
                new LodestoneItemProperties()
                        .fireResistant()
                        .rarity(SFRarities.SANGUIS_RARITY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(SFWeaponsTiers.LOST)
                        )
        );
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tips, TooltipFlag flag) {
        tips.add(Component.translatable("item.lost_scythe.tooltip1")
            .withStyle(ChatFormatting.GRAY));

        tips.add(Component.translatable("item.lost_scythe.tooltip2")
                .withStyle(net.minecraft.ChatFormatting.DARK_RED));
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.lost_scythe.name");
    }
}
