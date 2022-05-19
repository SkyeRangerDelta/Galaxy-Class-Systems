package net.skyerangerdelta.galaxyclasssystems.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skyerangerdelta.galaxyclasssystems.GalaxyClassSystems;
import net.skyerangerdelta.galaxyclasssystems.world.gen.ModOreGen;

@Mod.EventBusSubscriber(modid = GalaxyClassSystems.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent e) {
        ModOreGen.generateOre(e);
    }

}
