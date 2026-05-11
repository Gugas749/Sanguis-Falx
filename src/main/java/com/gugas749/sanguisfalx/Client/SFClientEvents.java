package com.gugas749.sanguisfalx.Client;

import com.gugas749.sanguisfalx.Registries.SFSpiritTypes;
import com.gugas749.sanguisfalx.Sanguisfalx;
import com.sammy.malum.common.item.spirit.SpiritShardItem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = Sanguisfalx.MODID, value = Dist.CLIENT)
public class SFClientEvents {

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) -> {
                    if (tintIndex == 0 && stack.getItem() instanceof SpiritShardItem spirit) {
                        return spirit.getSpirit().getColorProperties().itemColor().getRGB();
                    }
                    return -1;
                },
                SFSpiritTypes.SANGUIS_SPIRIT.get()
        );
    }
}
