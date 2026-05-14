package com.gugas749.sanguisfalx;

import com.gugas749.sanguisfalx.Registries.SFSpiritTypes;
import com.gugas749.sanguisfalx.Registries.SFCreativeModeTabs;
import com.gugas749.sanguisfalx.Registries.SFItemsRegistry;
import com.gugas749.sanguisfalx.Utils.SFArmorMaterials;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(Sanguisfalx.MODID)
public class Sanguisfalx {

    public static final String MODID = "sanguisfalx";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Sanguisfalx(IEventBus modEventBus, ModContainer modContainer) {
        SFSpiritTypes.register(modEventBus);
        SFArmorMaterials.register(modEventBus);
        //--------
        SFItemsRegistry.register(modEventBus);
        //--------
        SFCreativeModeTabs.register(modEventBus);
        //--------
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("[SanguisFalx] Succefully loaded!");
        });
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }



    @EventBusSubscriber(value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
