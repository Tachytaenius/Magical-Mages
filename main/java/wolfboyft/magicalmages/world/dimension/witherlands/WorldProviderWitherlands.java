package wolfboyft.magicalmages.world.dimension.witherlands;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import wolfboyft.magicalmages.world.biome.witherlands.BiomeRegistry;

public class WorldProviderWitherlands extends WorldProvider {

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(
				BiomeRegistry.biomeWitherlands, dimensionId);
		this.dimensionId = DimensionRegistry.dimensionId;
	}

	public IChunkProvider createChunkGeneration() {
		return null;
	}

	@Override
	public String getDimensionName() {
		return "Witherlands";
	}

	@Override
	public String getInternalNameSuffix() {
		return "Witherlands";
	}

}
