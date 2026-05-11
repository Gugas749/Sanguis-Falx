package com.gugas749.sanguisfalx.Registries;

import com.gugas749.sanguisfalx.Sanguisfalx;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SFCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Sanguisfalx.MODID);

    public static final Supplier<CreativeModeTab> SF_ITEMS = CREATIVE_MODE_TAB.register("sf_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(SFItemsRegistry.IRA.get()))
                    //.withTabsBefore(ResourceLocation.fromNamespaceAndPath(EnigmaticArcana.MOD_ID, "sf_materials"))
                    .title(Component.translatable("creativetab.sanguisfalx"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /*
                         *** SPIRIT
                         */

                        output.accept(SFSpiritTypes.SANGUIS_SPIRIT.get());

                        /*
                         *** WEAPONS
                         */

                        output.accept(SFItemsRegistry.SANGUIS_FALX.get());
                        output.accept(SFItemsRegistry.LOST_SCYTHE.get());

                        /*
                         *** CURIOS
                         */
                        output.accept(SFItemsRegistry.IRA.get());

                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
