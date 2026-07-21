package net.spottedtoad.toads_armor_sets.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.spottedtoad.toads_armor_sets.TASMod;

public class ModItemGroup {
    public static final ItemGroup ADDITIONS = FabricItemGroupBuilder.build(
            new Identifier(TASMod.MOD_ID, "toads_armor_sets"), () -> new ItemStack(ModItems.IRIDIANITE_INGOT));
}
