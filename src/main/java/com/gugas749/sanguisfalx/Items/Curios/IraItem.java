package com.gugas749.sanguisfalx.Items.Curios;

import com.gugas749.sanguisfalx.Utils.SFDispatcher;
import com.gugas749.sanguisfalx.Utils.SFRarities;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
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
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class IraItem extends CurioBaseItem {

    public final SFDispatcher dispatcher;

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
        attr.put(LodestoneAttributes.MAGIC_PROFICIENCY, new AttributeModifier(id, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(LodestoneAttributes.MAGIC_RESISTANCE, new AttributeModifier(id, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return attr;
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
