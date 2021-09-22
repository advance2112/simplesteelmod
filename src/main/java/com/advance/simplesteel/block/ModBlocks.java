package com.advance.simplesteel.block;

import com.advance.simplesteel.SimpleSteelMod;
import com.advance.simplesteel.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> STEEL_BLOCK = register("steel_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL)
                    .strength(5f,6f).sound(SoundType.METAL)));

    public static void register() { }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return toReturn;
    }
}
