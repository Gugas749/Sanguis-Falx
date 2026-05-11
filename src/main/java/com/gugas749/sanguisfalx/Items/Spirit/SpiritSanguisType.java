package com.gugas749.sanguisfalx.Items.Spirit;

import com.sammy.malum.common.item.spirit.SpiritShardItem;
import com.sammy.malum.core.systems.spirit.type.SpiritArcanaType;
import com.sammy.malum.core.systems.spirit.type.SpiritColorProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

public class SpiritSanguisType extends SpiritArcanaType {
    public SpiritSanguisType(SpiritColorProperties colorProperties,
                             DeferredHolder<Item, SpiritShardItem> spiritShard) {
        super(colorProperties, spiritShard);
    }
}
