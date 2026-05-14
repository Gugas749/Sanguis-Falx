package com.gugas749.sanguisfalx.Registries;

import com.gugas749.sanguisfalx.Items.Equipable.Armors.SanguisSet.SanguisArmorItem;
import com.gugas749.sanguisfalx.Items.Equipable.Curios.IraItem;
import com.gugas749.sanguisfalx.Items.Weapons.LostScytheItem;
import com.gugas749.sanguisfalx.Sanguisfalx;
import com.gugas749.sanguisfalx.Items.Weapons.SanguisFalxItem;
import com.gugas749.sanguisfalx.Utils.SFRarities;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

public class SFItemsRegistry {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Sanguisfalx.MODID);

    /*
     *** WEAPONS
     */
    public static final DeferredHolder<Item, Item> SANGUIS_FALX = ITEMS.register
            ("sanguis_falx", SanguisFalxItem::new);

    public static final DeferredHolder<Item, Item> LOST_SCYTHE = ITEMS.register
            ("lost_scythe", LostScytheItem::new);

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




    /*
     *** Armor
     */

    public static final DeferredHolder<Item, Item> SANGUIS_HELMET = ITEMS.register("sanguis_helmet",
            () -> new SanguisArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment(1)
                    .rarity(SFRarities.SANGUIS_RARITY.getValue())
                    .fireResistant()
                    .durability(ArmorItem.Type.HELMET.getDurability(64))
            ));
    public static final DeferredHolder<Item, Item> SANGUIS_CHESTPLATE = ITEMS.register("sanguis_chestplate",
            () -> new SanguisArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment(1)
                    .rarity(SFRarities.SANGUIS_RARITY.getValue())
                    .fireResistant()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))
            ));
    public static final DeferredHolder<Item, Item> SANGUIS_LEGGINGS = ITEMS.register("sanguis_leggings",
            () -> new SanguisArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment(1)
                    .rarity(SFRarities.SANGUIS_RARITY.getValue())
                    .fireResistant()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(64))
            ));
    public static final DeferredHolder<Item, Item> SANGUIS_BOOTS = ITEMS.register("sanguis_boots",
            () -> new SanguisArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment(1)
                    .rarity(SFRarities.SANGUIS_RARITY.getValue())
                    .fireResistant()
                    .durability(ArmorItem.Type.BOOTS.getDurability(64))
            ));
}
