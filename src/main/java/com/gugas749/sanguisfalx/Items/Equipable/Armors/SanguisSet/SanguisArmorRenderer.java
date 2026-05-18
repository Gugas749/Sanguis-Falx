package com.gugas749.sanguisfalx.Items.Equipable.Armors.SanguisSet;

import com.gugas749.sanguisfalx.Sanguisfalx;
import com.gugas749.sanguisfalx.Utils.SFAzArmorLeggingTorsoLayerPipeline;
import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;

public class SanguisArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            Sanguisfalx.MODID,
            "geo/armor/sanguis_armor.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            Sanguisfalx.MODID,
            "textures/armor/hannya.png"
    );

    public SanguisArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .setPipelineContext(SFAzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}
