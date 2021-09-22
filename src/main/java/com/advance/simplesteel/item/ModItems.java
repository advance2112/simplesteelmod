package com.advance.simplesteel.item;

import com.advance.simplesteel.util.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {

    public static final RegistryObject<Item> STEEL_INGOT =
            Registration.ITEMS.register("steel_ingot",
                    () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static void register() { }
}
