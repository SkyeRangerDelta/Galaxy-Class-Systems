package net.skyerangerdelta.galaxyclasssystems.world.gen;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.skyerangerdelta.galaxyclasssystems.GalaxyClassSystems;

import java.util.logging.Logger;

public class ModOreGen {
    public static final RuleTest END_STONE = new BlockMatchRuleTest(Blocks.END_STONE);

    public static void generateOre(final BiomeLoadingEvent e) {
        if (e.getCategory() == Biome.Category.THEEND) {
            for (OreType ore : OreType.values()) {
                if (ore.isEndOnly()) {
                    OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(
                            END_STONE,
                            ore.getBlock().get().getDefaultState(),
                            ore.getMaxVeinSize()
                    );

                    ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                            new TopSolidRangeConfig(ore.getMinVeinHeight(), 0, ore.getMaxVeinHeight())
                    );

                    ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

                    e.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
                }
            }
        }
        else {
            for (OreType ore : OreType.values()) {
                if (!ore.isEndOnly()) {
                    OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(
                            OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                            ore.getBlock().get().getDefaultState(),
                            ore.getMaxVeinSize()
                    );

                    ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                            new TopSolidRangeConfig(ore.getMinVeinHeight(), ore.getMinVeinHeight(), ore.getMaxVeinHeight())
                    );

                    ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

                    e.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
                }
            }
        }
    }

    public static ConfiguredFeature<?, ?> registerOreFeature(
            OreType ore,
            OreFeatureConfig oreFeatureConfig,
            ConfiguredPlacement oreFeaturePlacement) {

        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
                Feature.ORE
                        .withConfiguration(oreFeatureConfig)
                        .withPlacement(oreFeaturePlacement)
                        .square().count(ore.getMaxVeinSize()));
    }
}
