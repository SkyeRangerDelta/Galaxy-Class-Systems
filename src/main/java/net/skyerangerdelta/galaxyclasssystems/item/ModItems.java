package net.skyerangerdelta.galaxyclasssystems.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.skyerangerdelta.galaxyclasssystems.GalaxyClassSystems;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GalaxyClassSystems.MOD_ID);

    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot",
            () -> new Item(new Item.Properties().tab(ModItemGroup.TAB_GALAXYCLASS)));

    public static final RegistryObject<Item> DURANIUM_CHUNK = ITEMS.register("duranium_chunk",
            () -> new Item(new Item.Properties().tab(ModItemGroup.TAB_GALAXYCLASS)));

    public static final RegistryObject<Item> TRITANIUM_ALLOY = ITEMS.register("tritanium_alloy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.TAB_GALAXYCLASS)));

    public static final RegistryObject<Item> TERMINIUM_ALLOY = ITEMS.register("terminium_alloy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.TAB_GALAXYCLASS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
