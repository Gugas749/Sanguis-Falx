package com.gugas749.sanguisfalx.Registries;

import com.gugas749.sanguisfalx.Items.Curios.IraItem;
import com.gugas749.sanguisfalx.Items.Spirit.SpiritSanguisType;
import com.gugas749.sanguisfalx.Sanguisfalx;
import com.gugas749.sanguisfalx.Items.Weapons.SanguisFalxItem;
import com.sammy.malum.common.item.spirit.SpiritShardItem;
import com.sammy.malum.core.systems.registry.SpiritHolder;
import com.sammy.malum.core.systems.spirit.type.SpiritArcanaType;
import com.sammy.malum.core.systems.spirit.type.SpiritColorProperties;
import com.sammy.malum.registry.common.magic.MalumSpiritTypes;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import team.lodestar.lodestone.systems.easing.Easing;

import java.awt.*;
import java.util.Collection;

public class SFItemsRegistry {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Sanguisfalx.MODID);

    /*
     *** WEAPONS
     */
    public static final DeferredHolder<Item, Item> SANGUIS_FALX = ITEMS.register
            ("sanguis_falx", SanguisFalxItem::new);


    /*
     *** Curios
     */
    public static final DeferredItem<IraItem> IRA = ITEMS.register("ira", IraItem::new);

    public static Collection<DeferredHolder<Item, ? extends Item>> getSFItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
