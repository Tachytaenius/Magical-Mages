package wolfboyft.magicalmages.world.biome.witherlands;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class BiomeGenWitherlands extends BiomeGenBase implements
		IWorldGenerator {

	public BiomeGenWitherlands(int id) {
		super(id);
	}

	@Override
	public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_) {
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	}
}
