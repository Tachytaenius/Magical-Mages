package wolfboyft.magicalmages.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {

	public static BiomeGenBase biomeWitherlands;

	public static void mainRegistry() {
		initializeBiome();
		registerBiome();
	}

	private static void registerBiome() {
		BiomeDictionary.registerBiomeType(biomeWitherlands, Type.SPOOKY);
		BiomeManager.addSpawnBiome(biomeWitherlands);
	}

	private static void initializeBiome() {
		biomeWitherlands = new BiomeGenWitherlands(25).setBiomeName(
				"Witherlands").setTemperatureRainfall(1.2F, 0.9F);
	}
}
