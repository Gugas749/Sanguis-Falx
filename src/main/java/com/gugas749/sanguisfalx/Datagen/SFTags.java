package com.gugas749.sanguisfalx.Datagen;

import com.gugas749.sanguisfalx.Sanguisfalx;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class SFTags {

    /*
     *** Items
     */
    public static final TagKey<Item> IDLE_ARMOR = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(Sanguisfalx.MODID, "armor/idle_armor").toString()));
}
