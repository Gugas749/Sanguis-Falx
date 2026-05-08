package com.gugas749.sanguisfalx.Utils;

import net.minecraft.world.item.Rarity;
import net.minecraft.network.chat.Style;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import java.util.function.UnaryOperator;

public class SFRarities {

    public static final EnumProxy<Rarity> SANGUIS_RARITY = new EnumProxy<>(Rarity.class,
            -1,
            "sanguisfalx:sanguis",
            (UnaryOperator<Style>) ((style) -> style.withColor(0x841236))
    );
}
