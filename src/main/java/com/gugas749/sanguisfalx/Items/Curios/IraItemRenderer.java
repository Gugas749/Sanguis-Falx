package com.gugas749.sanguisfalx.Items.Curios;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.gugas749.sanguisfalx.Sanguisfalx;
import com.gugas749.sanguisfalx.Utils.SFDispatcher;
import com.gugas749.sanguisfalx.Utils.SFRarities;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
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

public class IraItemRenderer extends AzArmorRenderer {

    public static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            Sanguisfalx.MODID,
            "geo/curios/ira.geo.json"
    );

    public static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            Sanguisfalx.MODID,
            "textures/curios/ira.png"
    );

    public IraItemRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(IraItemAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}
