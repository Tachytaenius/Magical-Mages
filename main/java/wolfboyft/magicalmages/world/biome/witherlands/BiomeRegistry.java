package wolfboyft.magicalmages.world.biome.witherlands;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {

	public static BiomeGenBase biomeWitherlands = new BiomeGenWitherlands(52);

	public static void mainRegistry() {
		registerBiome();
		initializeBiome();
	}

	private static void registerBiome() {
		BiomeDictionary.registerBiomeType(biomeWitherlands, Type.SPOOKY,
				Type.COLD, Type.DEAD);
		BiomeManager.addSpawnBiome(biomeWitherlands);
	}

	private static void initializeBiome() {
		biomeWitherlands = new BiomeGenWitherlands(52).setBiomeName(
				"Witherlands").setDisableRain();
	}
}
