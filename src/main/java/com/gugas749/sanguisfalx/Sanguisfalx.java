package com.gugas749.sanguisfalx;

import com.gugas749.sanguisfalx.common.Registries.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

// @Mod marks this class as the NeoForge mod entry point.
// NeoForge reads this annotation and calls the constructor when Minecraft loads the mod.
// Think of it like @Application in Android — it's the first thing that runs.
// The string inside must match the modid in neoforge.mods.toml.
@Mod(Sanguisfalx.MODID)
public class Sanguisfalx {

    // The mod's unique ID used everywhere to identify assets, packets, registry entries, etc.
    // Like a package name (com.example.myapp) in Android, but shorter.
    public static final String MODID = "sanguisfalx";

    // Logger for printing debug/info messages to the game console and log file.
    // Equivalent to Log.d() in Android or Console.WriteLine() in C#.
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Sanguisfalx(IEventBus modEventBus, ModContainer modContainer) {

        // Register all custom items with Minecraft's registry via a DeferredRegister.
        // DeferredRegister is a lazy container — items are not registered right now,
        // they queue up and register themselves when the correct setup event fires.
        // Similar to a ServiceLocator / DI container that resolves dependencies lazily.
        ModItems.ITEMS.register(modEventBus);

        // Register the contract data attachment types (the persistent per-player data storage).
        //ContractCapability.ATTACHMENT_TYPES.register(modEventBus);

        // Subscribe our commonSetup method to the FMLCommonSetupEvent.
        // "this::commonSetup" is a method reference — the Java equivalent of a delegate in C#.
        // This method will be called during the "common setup" phase (runs on both client and server).
        modEventBus.addListener(this::commonSetup);

        // Subscribe the PacketHandler's static method to the payload registration event.
        // This is how the mod tells NeoForge which network packets exist.
        //modEventBus.addListener(PacketHandler::registerPayloads);
    }

    // Runs once during the common setup phase (after items are registered, before the game starts).
    // event.enqueueWork() defers the lambda to run safely on the main thread —
    // equivalent to runOnUiThread() in Android or Control.Invoke() in C# WinForms.
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("[SanguisFalx] Succefully loaded!");
        });
    }

    // Utility helper: builds a ResourceLocation namespaced to this mod.
    // A ResourceLocation is a two-part key: "namespace:path" (e.g. "abcontrato:contract_action").
    // Used everywhere to uniquely identify assets, registry entries, network channels, etc.
    // Think of it like a URI or a fully qualified class name.
    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
