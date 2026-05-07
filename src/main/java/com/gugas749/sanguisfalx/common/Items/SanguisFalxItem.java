package com.gugas749.sanguisfalx.common.Items;

import com.gugas749.sanguisfalx.common.Utils.Rarities;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

public class SanguisFalxItem extends TieredItem {

    // ── Weapon stats — change these to tune the weapon ──────────────────────
    // Attack damage: final value = (player attribute base) + tier bonus + DAMAGE_BONUS
    // Tiers.NETHERITE = 4, TOTAL: 1 + 4 + 15 = 20
    private static final int DAMAGE_BONUS = 15;

    // Attack speed: offset from the base of 4.0 attacks/sec
    //   -2.4 is vanilla sword default (= 1.6/sec). -2.0 = 2.0/sec (faster).
    private static final float ATTACK_SPEED = -2.0F;

    // Durability: how many hits before the item breaks
    //private static final int DURABILITY = 3000;
    // ────────────────────────────────────────────────────────────────────────

    public SanguisFalxItem(Properties properties) {
        super(Tiers.NETHERITE, properties.stacksTo(1)
                .rarity(Rarities.SANGUIS_RARITY.getValue())
                .attributes(SwordItem.createAttributes(Tiers.NETHERITE, DAMAGE_BONUS, ATTACK_SPEED)));
    }

    // Adds hover tooltip lines shown when the player hovers over this item in their inventory.
    // Android analogy: a custom View's setContentDescription() or a tooltip popup.
    // C# WinForms analogy: toolTip1.SetToolTip(button, "..."); but for inventory items.
    //
    // @OnlyIn(Dist.CLIENT) because tooltips are only rendered on the client.
    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tips, TooltipFlag flag) {
        // Add two lines to the item tooltip, styled with Minecraft's colour codes.
        // .withStyle() applies colour formatting — like HTML <span style="color:..."> or
        // SpannableString in Android.
        tips.add(Component.translatable("item.sanguisfalx.tooltip1")
            .withStyle(net.minecraft.ChatFormatting.DARK_RED));
    }

    // Overrides the item's display name.
    // By default, getName() would derive the name from the item's registry ID.
    // Here we return a translatable Component so it respects the player's language setting.
    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.sanguisfalx.name");
    }
}
