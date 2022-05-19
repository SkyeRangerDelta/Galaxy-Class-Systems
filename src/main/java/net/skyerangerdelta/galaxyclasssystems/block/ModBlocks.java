package net.skyerangerdelta.galaxyclasssystems.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.skyerangerdelta.galaxyclasssystems.GalaxyClassSystems;
import net.skyerangerdelta.galaxyclasssystems.item.ModItemGroup;
import net.skyerangerdelta.galaxyclasssystems.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GalaxyClassSystems.MOD_ID);

    public static final RegistryObject<Block> MOLYBDENUM_ORE = registerBlock("molybdenum_ore",
            () -> new Block(AbstractBlock.Properties
                    .create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(5f)));

    public static final RegistryObject<Block> MOLYBDENUM_BLOCK = registerBlock("molybdenum_block",
            () -> new Block(AbstractBlock.Properties
                    .create(Material.IRON)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(6f)));
    public static final RegistryObject<Block> DILITHIUM_CRYSTAL_BLOCK = registerBlock("dilithium_crystal_block",
            () -> new Block(AbstractBlock.Properties
                    .create(Material.GLASS)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .hardnessAndResistance(6f)));


    private  static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.TAB_GALAXYCLASS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
