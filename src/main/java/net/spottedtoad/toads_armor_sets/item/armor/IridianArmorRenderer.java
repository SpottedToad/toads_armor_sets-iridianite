package net.spottedtoad.toads_armor_sets.item.armor;

import mod.azure.azurelib.render.armor.AzArmorRenderer;
import mod.azure.azurelib.render.armor.AzArmorRendererConfig;
import net.minecraft.util.Identifier;
import net.spottedtoad.toads_armor_sets.TASMod;

public class IridianArmorRenderer extends AzArmorRenderer {
    private static final Identifier MODEL = new Identifier(
            TASMod.MOD_ID,
            "geo/iridian_armor.geo.json"
    );

    private static final Identifier TEXTURE = new Identifier(
            TASMod.MOD_ID,
            "textures/armor/iridian_armor.png"
    );

    public IridianArmorRenderer() {
        super(AzArmorRendererConfig.builder(MODEL, TEXTURE)
                .setBoneProvider(new IridianArmorBoneProvider())
                .build()
        );
    }

}