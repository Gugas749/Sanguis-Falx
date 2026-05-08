package com.gugas749.sanguisfalx.Utils;

import com.sammy.malum.common.item.curiosities.weapons.scythe.MagicScytheItem;
import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import team.lodestar.lodestone.systems.item.LodestoneItemProperties;

public class SanguisScytheItem extends MagicScytheItem implements IPresetSpellContainer {
    public SanguisScytheItem(Tier tier, float attackDamage, float attackSpeed, float magicDamage, LodestoneItemProperties properties) {
        super(tier, attackDamage, attackSpeed, magicDamage, properties);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
    }
}
