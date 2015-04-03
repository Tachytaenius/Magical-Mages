package wolfboyft.magicalmages.world.biome.witherlands;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import wolfboyft.magicalmages.entity.mob.enemy.actual.WitherGuardian;
import wolfboyft.magicalmages.init.MageBlocks;

public class BiomeGenWitherlands extends BiomeGenBase implements
		IWorldGenerator {
	public BiomeGenWitherlands(int id) {
		super(id);
		this.topBlock = MageBlocks.witherMoss.getDefaultState();
		this.fillerBlock = MageBlocks.witherRock.getDefaultState();
		this.color = 250000;
		this.waterColorMultiplier = 0xEF0000;
		this.theBiomeDecorator.clayPerChunk = 8;
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(
				WitherGuardian.class, 100, 5, 8));
	}

	@Override
	public void decorate(World worldIn, Random p_180624_2_, BlockPos p_180624_3_) {
		this.theBiomeDecorator.generateLakes = true;
		this.theBiomeDecorator.sandPerChunk = 7;
		this.theBiomeDecorator.deadBushPerChunk = 8;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	}

	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x900000;
	}
}
