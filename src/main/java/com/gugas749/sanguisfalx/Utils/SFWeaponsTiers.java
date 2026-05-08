package com.gugas749.sanguisfalx.Utils;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class SFWeaponsTiers implements Tier, IronsWeaponTier {

    public static final SFWeaponsTiers SANGUIS = new SFWeaponsTiers(
            8064,
            2F,
            1.3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.EMPTY,
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, 0.30, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.30, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 5, AttributeModifier.Operation.ADD_VALUE)
    );

    private final int uses;
    private final float damage;
    private final float speed;
    private final int enchantmentValue;
    private final TagKey<Block> incorrectBlocksForDrops;
    Supplier<Ingredient> repairIngredient;
    private final AttributeContainer[] attributes;

    private SFWeaponsTiers(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient, AttributeContainer... attributes) {
        this.uses = uses;
        this.damage = damage;
        this.speed = speed;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
        this.attributes = attributes;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return attributes;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
