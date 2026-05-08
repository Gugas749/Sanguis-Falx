package com.gugas749.sanguisfalx.Registries;

import com.gugas749.sanguisfalx.Sanguisfalx;
import com.gugas749.sanguisfalx.Items.SanguisFalxItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SFItemsRegistry {

    // DeferredRegister.Items is a helper that queues item registrations.
    // Items registered here will be added to Minecraft's global item registry
    // during the "item registration" phase (before the game fully loads).
    //
    // "Deferred" = registrations are queued now, executed later at the right time.
    // This avoids race conditions during mod loading.
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Sanguisfalx.MODID);

    // Registers the Sanguis Flax item.
    // DeferredItem<Item> is a lazy reference — it wraps the item and resolves once registered.
    // registerItem(name, factory):
    //   - "sanguis_flax" becomes the item's registry ID: "sanguisflax:sanguis_flax"
    //   - SanguisFlaxItem::new is the constructor reference that creates the item instance.
    //     It's called with a fresh Item.Properties object automatically.
    public static final DeferredHolder<Item, Item> SANGUIS_FALX = ITEMS.register
            ("sanguis_falx", SanguisFalxItem::new);
}
