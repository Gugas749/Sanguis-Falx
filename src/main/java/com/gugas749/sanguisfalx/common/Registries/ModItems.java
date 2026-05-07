package com.gugas749.sanguisfalx.common.Registries;

import com.gugas749.sanguisfalx.Sanguisfalx;
import com.gugas749.sanguisfalx.common.Items.SanguisFalxItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// Registers all custom items for this mod with Minecraft's item registry.
//
// @EventBusSubscriber(bus = MOD) means NeoForge scans this class for @SubscribeEvent
// methods that are on the MOD event bus (startup/registration events) rather than
// the FORGE bus (runtime game events like player ticks or block breaks).
//
// Android analogy: registering Services/Activities in AndroidManifest.xml —
//   items can't exist unless they're declared here.
// C# WinForms analogy: registering custom controls or components with a factory/registry
//   before they can be used.
@EventBusSubscriber(modid = Sanguisfalx.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModItems {

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
    public static final DeferredItem<Item> SANGUIS_FALX =
            ITEMS.registerItem("sanguis_falx", SanguisFalxItem::new);

    // Adds our item to Minecraft's Creative Mode inventory tab.
    // This event fires once during setup when Minecraft is building the creative tabs.
    //
    // BuildCreativeModeTabContentsEvent fires for EVERY creative tab — we check
    // event.getTabKey() to only add our item to the TOOLS_AND_UTILITIES tab.
    //
    // Android analogy: registering a shortcut or a menu entry in a specific category.
    // C# WinForms analogy: adding a ToolStripItem to a specific ToolStrip.
    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            // event.accept() adds our item to this tab's inventory.
            event.accept(SANGUIS_FALX);
        }
    }
}
