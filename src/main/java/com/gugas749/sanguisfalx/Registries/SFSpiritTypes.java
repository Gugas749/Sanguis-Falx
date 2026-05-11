package com.gugas749.sanguisfalx.Registries;

import com.gugas749.sanguisfalx.Sanguisfalx;
import com.sammy.malum.common.item.spirit.SpiritShardItem;
import com.sammy.malum.core.systems.registry.DeferredSpiritTypes;
import com.sammy.malum.core.systems.registry.SpiritHolder;
import com.sammy.malum.core.systems.spirit.type.SpiritArcanaType;
import com.sammy.malum.core.systems.spirit.type.SpiritColorProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import team.lodestar.lodestone.systems.easing.Easing;

import java.awt.*;

public class SFSpiritTypes {

    public static final DeferredSpiritTypes SPIRIT_TYPES =
            DeferredSpiritTypes.create(Sanguisfalx.MODID);

    public static final DeferredHolder<Item, SpiritShardItem> SANGUIS_SPIRIT =
            SFItemsRegistry.ITEMS.register("sanguis_spirit", () ->
                    new SpiritShardItem(new Item.Properties(),
                            SpiritHolder.getSpiritType(Sanguisfalx.rl("sanguis"))
                    )
            );

    public static SpiritColorProperties SANGUIS_COLORS() {
        return SpiritColorProperties.create(new Color(0x841236), new Color(0x4a0a1e))
                .setColorCoefficient(0.9f)
                .setColorEasing(Easing.SINE_IN_OUT)
                .build();
    }

    public static final SpiritHolder<SpiritArcanaType> SANGUIS_TYPE =
            SPIRIT_TYPES.register("sanguis", () ->
                    new SpiritArcanaType(SANGUIS_COLORS(), SANGUIS_SPIRIT)
            );

    public static void register(IEventBus eventBus) {
        SPIRIT_TYPES.register(eventBus);
    }
}
