package com.gugas749.sanguisfalx.Utils;

import com.gugas749.sanguisfalx.Sanguisfalx;
import com.sammy.malum.registry.common.item.MalumItems;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class SFArmorMaterials {

    private static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Sanguisfalx.MODID);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> SANGUIS_MATERIAL = register("sanguis",
            sanguisArmorMap(),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(MalumItems.SOUL_STAINED_STEEL_PLATING.get()),
            6,
            0.25F
    );


    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance)
    {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Sanguisfalx.rl(name)));
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, list, toughness, knockbackResistance));
    }

    public static EnumMap<ArmorItem.Type, Integer> makeArmorMap(int helmet, int chestplate, int leggings, int boots)
    {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
            typeIntegerEnumMap.put(ArmorItem.Type.HELMET, helmet);
            typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, chestplate);
            typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, leggings);
            typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, boots);
        });
    }

    public static EnumMap<ArmorItem.Type, Integer> sanguisArmorMap(){
        return makeArmorMap(8, 14, 11, 7);
    }

    public static void register(IEventBus eventBus)
    {
        ARMOR_MATERIALS.register(eventBus);
    }
}
