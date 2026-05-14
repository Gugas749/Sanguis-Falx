package com.gugas749.sanguisfalx.Items.Equipable.Armors.SanguisSet;

import com.gugas749.sanguisfalx.Utils.SFArmorMaterials;
import com.gugas749.sanguisfalx.Utils.SFDispatcher;
import com.gugas749.sanguisfalx.Utils.SFImbuableArmorItem;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;

public class SanguisArmorItem extends SFImbuableArmorItem implements IDisableJacket, IDisableHat {
    public final SFDispatcher dispatcher;

    public SanguisArmorItem(Type type, Properties properties) {
        super(SFArmorMaterials.SANGUIS_MATERIAL,
                type,
                properties,
                pureTierMalum(
                        300,
                        0.25f,
                        0.8f,
                        8,
                        0.4F
                ));
        this.dispatcher = new SFDispatcher();
    }
}
