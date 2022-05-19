package net.skyerangerdelta.galaxyclasssystems.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup TAB_GALAXYCLASS = new ItemGroup("galaxyClassTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.MOLYBDENUM_INGOT.get());
        }
    };
}
