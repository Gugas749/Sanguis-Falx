package com.gugas749.sanguisfalx.Datagen.Providers;

import com.gugas749.sanguisfalx.Registries.SFItemsRegistry;
import com.gugas749.sanguisfalx.Sanguisfalx;
import com.sammy.malum.registry.common.MalumTags;
import io.redspace.ironsspellbooks.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class SFItemTagProvider extends ItemTagsProvider {
    public SFItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Sanguisfalx.MODID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        /*
         *** Enchantable Tags
         */

        tag(Tags.Items.ENCHANTABLES)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;

        /*
         *** Tools and Weapons Tags
         */

        tag(ItemTags.SWORDS)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;

        // --------- IRON SPELLS ----------
        tag(ModTags.CAN_BE_IMBUED)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;

        tag(ModTags.CAN_BE_UPGRADED)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;

        // --------- MALUM ----------
        tag(MalumTags.ItemTags.SCYTHES)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;

        tag(MalumTags.ItemTags.MAGIC_CAPABLE_WEAPON)
                .add(SFItemsRegistry.SANGUIS_FALX.get())
        ;
    }
}
