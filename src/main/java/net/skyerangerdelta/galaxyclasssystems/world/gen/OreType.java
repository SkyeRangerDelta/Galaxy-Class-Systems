package net.skyerangerdelta.galaxyclasssystems.world.gen;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;
import net.skyerangerdelta.galaxyclasssystems.block.ModBlocks;

public enum OreType {

    DILITHIUM_CRYSTAL_SHARD(Lazy.of(ModBlocks.DILITHIUM_CRYSTAL_BLOCK), 3, 1, 70, true),
    MOLYBDENUM_ORE(Lazy.of(ModBlocks.MOLYBDENUM_ORE), 8, 1, 60, false);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minVeinHeight;
    private final int maxVeinHeight;
    private final boolean endOnly;

    OreType(Lazy<Block> block, int maxVeinSize, int minVeinHeight, int maxVeinHeight, boolean endOnly) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minVeinHeight = minVeinHeight;
        this.maxVeinHeight = maxVeinHeight;
        this.endOnly = endOnly;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinVeinHeight() {
        return minVeinHeight;
    }

    public int getMaxVeinHeight() {
        return maxVeinHeight;
    }

    public boolean isEndOnly() {
        return endOnly;
    }

    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }

        return null;
    }
}
