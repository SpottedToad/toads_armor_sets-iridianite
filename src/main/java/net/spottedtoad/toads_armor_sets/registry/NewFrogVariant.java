package net.spottedtoad.toads_armor_sets.registry;

import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.spottedtoad.toads_armor_sets.TASMod;

public class NewFrogVariant
{
    public static final FrogVariant SPACE = createFrogVariant("space", "space_frog");

    private static FrogVariant createFrogVariant(String name, String texture)
    {
        return Registry.register(Registry.FROG_VARIANT, new Identifier(TASMod.MOD_ID, name), new FrogVariant(new Identifier(TASMod.MOD_ID, "textures/entity/" + texture + ".png")));
    }

    public static void init() {}
}