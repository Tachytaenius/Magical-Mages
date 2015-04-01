package wolfboyft.magicalmages.world.dimension.witherlands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import wolfboyft.magicalmages.init.MageBlocks;

public class TeleporterWitherlands extends Teleporter {

	private final WorldServer worldServerInstance;
	private final Random random;
	private final LongHashMap destinationCoordinateCache = new LongHashMap();
	private final List destinationCoordinateKeys = new ArrayList();

	public TeleporterWitherlands(WorldServer worldIn) {
		super(worldIn);
		this.worldServerInstance = worldIn;
		this.random = new Random(worldIn.getSeed());
	}

	public void placeInPortal(Entity entity, double par2, double par4,
			double par6, float par8) {
		if (!this.placeInExistingPortal(entity, par8)) {
			this.makePortal(entity);
			this.placeInExistingPortal(entity, par8);
		} else {
			int i = MathHelper.floor_double(entity.posX);
			int j = MathHelper.floor_double(entity.posY) - 1;
			int k = MathHelper.floor_double(entity.posZ);
			byte b0 = 1;
			byte b1 = 0;

			for (int l = -2; l <= 2; ++l) {
				for (int i1 = -2; i1 <= 2; ++i1) {
					for (int j1 = -1; j < 3; ++j1) {
						int k1 = i + i1 * b0 + l * b1;
						int l1 = j + j1;
						int i2 = k + i1 * b1 - l * b0;
						boolean flag = j1 < 0;
						/*
						 * new BlockPos(k1, l1, i2),
						 */
						this.worldServerInstance.setBlockState(new BlockPos(k1,
								l1, i2),
								(IBlockState) (flag ? MageBlocks.witherCore
										: Blocks.air));
					}
				}
			}

			entity.setLocationAndAngles((double) i, (double) j, (double) k,
					entity.rotationYaw, 0.0F);
		}
	}

	public boolean placeInExistingPortal(Entity entity, double par2,
			double par4, double par6, float par8) {
		short short1 = 128;
		double d3 = -1.0D;
		int i = 0;
		int j = 0;
		int k = 0;
		int l = MathHelper.floor_double(entity.posX);
		int i1 = MathHelper.floor_double(entity.posZ);
		long j1 = ChunkCoordIntPair.chunkXZ2Int(l, i1);
		boolean flag = true;
		double d7;
		int l3;

		if (this.destinationCoordinateCache.containsItem(j1)) {
			TeleporterWitherlands.PortalPosition portalposition = (Teleporter.PortalPosition) this.destinationCoordinateCache
					.getValueByKey(j1);
			d3 = 0.0;
			i = portalposition.getX();
			j = portalposition.getY();
			k = portalposition.getZ();
			portalposition.lastUpdateTime = this.worldServerInstance
					.getTotalWorldTime();
			flag = false;
		}

		return false;
	}
}