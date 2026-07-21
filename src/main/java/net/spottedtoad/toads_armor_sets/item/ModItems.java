package net.spottedtoad.toads_armor_sets.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.spottedtoad.toads_armor_sets.TASMod;
import net.minecraft.item.Item;
import net.spottedtoad.toads_armor_sets.item.custom.IridianArmorItem;

public class ModItems {
    public static final Item IRIDIAN_CRYSTAL = registerItem("iridian_crystal",
            new Item(new FabricItemSettings().group(ModItemGroup.ADDITIONS)));
    public static final Item IRIDIANITE_INGOT = registerItem("iridianite_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.ADDITIONS)));

    public static final Item IRIDIANITE_HELMET = registerItem("iridianite_helmet",
            new IridianArmorItem(ModArmorMaterial.IRIDIANITE, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.ADDITIONS)));
    public static final Item IRIDIANITE_CHESTPLATE = registerItem("iridianite_chestplate",
            new IridianArmorItem(ModArmorMaterial.IRIDIANITE, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.ADDITIONS)));
    public static final Item IRIDIANITE_LEGGINGS = registerItem("iridianite_leggings",
            new IridianArmorItem(ModArmorMaterial.IRIDIANITE, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.ADDITIONS)));
    public static final Item IRIDIANITE_BOOTS = registerItem("iridianite_boots",
            new IridianArmorItem(ModArmorMaterial.IRIDIANITE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.ADDITIONS)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TASMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TASMod.LOGGER.debug("Registering Mod Items for " + TASMod.MOD_ID);
    }
}
