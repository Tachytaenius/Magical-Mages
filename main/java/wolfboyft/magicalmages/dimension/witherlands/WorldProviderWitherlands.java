package wolfboyft.magicalmages.dimension.witherlands;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import wolfboyft.magicalmages.MagicalMages;

public class WorldProviderWitherlands extends WorldProvider {

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(
				BiomeGenBase.desertHills, MagicalMages.dimensionId);
		this.dimensionId = MagicalMages.dimensionId;
	}

	public String getDimensionName() {
		return "Witherlands";
	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderWitherlands(worldObj, worldObj.getSeed(), true);
	}

	@Override
	public String getInternalNameSuffix() {
		return "witherlands";
	}
}
