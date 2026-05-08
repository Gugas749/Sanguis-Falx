package com.gugas749.sanguisfalx.Items.Curios;

import com.gugas749.sanguisfalx.Utils.SFDispatcher;
import com.gugas749.sanguisfalx.Utils.SFRarities;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import team.lodestar.lodestone.registry.common.LodestoneAttributes;
import top.theillusivec4.curios.api.CuriosTooltip;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class IraItem extends CurioBaseItem {

    public final SFDispatcher dispatcher;

    private static final double MAGIC_PROFICIENCY_BONUS = 0.25;
    private static final double MAGIC_RESISTANCE_BONUS = 0.25;

    public IraItem() {
        super(ItemPropertiesHelper
                .equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(SFRarities.SANGUIS_RARITY.getValue())
        );

        this.dispatcher = new SFDispatcher();
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(LodestoneAttributes.MAGIC_PROFICIENCY, new AttributeModifier(id, MAGIC_PROFICIENCY_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(LodestoneAttributes.MAGIC_RESISTANCE, new AttributeModifier(id, MAGIC_RESISTANCE_BONUS, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return attr;
    }

    @Override
    public List<Component> getAttributesTooltip(List<Component> tooltips, TooltipContext context, ItemStack stack) {
        return new CuriosTooltip()
                .forSlots("curio")
                .appendAdditive(attributeTooltip(LodestoneAttributes.MAGIC_PROFICIENCY))
                .appendAdditive(attributeTooltip(LodestoneAttributes.MAGIC_RESISTANCE))
                .build();
    }

    private static MutableComponent attributeTooltip(Holder<Attribute> attribute) {
        return Component.translatable(
                "attribute.modifier.plus.1",
                20,
                Component.translatable(attribute.value().getDescriptionId())
        ).withStyle(ChatFormatting.BLUE);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player )
        {
            dispatcher.idle(player, stack);
        }
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tips, TooltipFlag flag) {
        // Add two lines to the item tooltip, styled with Minecraft's colour codes.
        // .withStyle() applies colour formatting — like HTML <span style="color:..."> or
        // SpannableString in Android.
        tips.add(Component.translatable("item.ira.tooltip1")
                .withStyle(net.minecraft.ChatFormatting.RED));

        tips.add(Component.translatable("item.ira.tooltip2")
                .withStyle(net.minecraft.ChatFormatting.DARK_RED));
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable("item.ira.name");
    }
}
