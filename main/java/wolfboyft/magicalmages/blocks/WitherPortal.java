package wolfboyft.magicalmages.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import wolfboyft.magicalmages.init.MageBlocks;
import wolfboyft.magicalmages.world.dimension.witherlands.DimensionRegistry;
import wolfboyft.magicalmages.world.dimension.witherlands.TeleporterWitherlands;

public class WitherPortal extends BlockPortal {
	public WitherPortal() {
		super();
	}

	/*
	 * public void updateTick(World world, int x, int y, int z, Random rand) {
	 * 
	 * }
	 */

	public boolean renderAsNormalBlock() {
		return false;
	}

	public void onBlockClicked(World world, BlockPos position,
			EntityPlayer player) {

	}

	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block block) {
		byte b0 = 0;
		byte b1 = 1;

		int i1;

		for (i1 = y; world.getBlockState(new BlockPos(x, y, z)).getBlock() == this; --i1) {
		}
		if (world.getBlockState(new BlockPos(x, y, z)).getBlock() != MageBlocks.witherCore) {
			world.setBlockToAir(new BlockPos(x, y, z));
		} else {

			int j1;

			for (j1 = 1; j1 < 4
					&& world.getBlockState(new BlockPos(x, i1 + j1, z))
							.getBlock() == this; ++j1) {
			}
			if (j1 == 3
					&& world.getBlockState(new BlockPos(x, i1 + j1, z))
							.getBlock() == MageBlocks.witherCore) {
				boolean flag = world.getBlockState(new BlockPos(x - 1, y, z))
						.getBlock() == this
						|| world.getBlockState(new BlockPos(x + 1, y, z))
								.getBlock() == this;
				boolean flag1 = world.getBlockState(new BlockPos(x, y, z - 1))
						.getBlock() == this
						|| world.getBlockState(new BlockPos(x, y, z + 1))
								.getBlock() == this;

				if (flag && flag1) {
					world.setBlockToAir(new BlockPos(x, y, z));
				} else {
					if (world.getBlockState(new BlockPos(x + b0, y, z + b1))
							.getBlock() != MageBlocks.witherCore
							|| world.getBlockState(
									new BlockPos(x - b0, y, z - b1)).getBlock() != this
							&& (world.getBlockState(
									new BlockPos(x - b0, y, z - b1)).getBlock() != MageBlocks.witherCore)
							|| (world.getBlockState(
									new BlockPos(x + b0, y, z + b1)).getBlock() != this)) {
						world.setBlockToAir(new BlockPos(x, y, z));
					}
				}
			} else {
				world.setBlockToAir(new BlockPos(x, y, z));
			}
		}
	}

	public int quantityDropped(Random rand) {
		return 0;
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z,
			Entity entity) {
		if (entity.ridingEntity == null && entity.riddenByEntity == null
				&& entity instanceof EntityPlayerMP) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
			MinecraftServer server = MinecraftServer.getServer();
			if (entity instanceof EntityPlayerMP) {
				if (thePlayer.timeUntilPortal > 0) {
					thePlayer.timeUntilPortal = 10;
				} else if (thePlayer.dimension != DimensionRegistry.dimensionId) {
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer
							.getConfigurationManager()
							.transferPlayerToDimension(
									thePlayer,
									DimensionRegistry.dimensionId,
									new TeleporterWitherlands(
											server.worldServerForDimension(DimensionRegistry.dimensionId)));
				} else {
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getConfigurationManager()
							.transferPlayerToDimension(
									thePlayer,
									0,
									new TeleporterWitherlands(server
											.worldServerForDimension(0)));
				}
			}
		}
	}

	public boolean tryTroCreatePortal(World world, int x, int y, int z) {
		byte b0 = 0;
		byte b1 = 0;
		if (world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == MageBlocks.witherCore
				|| world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == MageBlocks.witherCore) {
			b0 = 1;
		}

		if (world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == MageBlocks.witherCore
				|| world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == MageBlocks.witherCore) {
			b1 = 1;
		}

		if (b0 == b1) {
			return false;

		} else {
			if (world.getBlockState(new BlockPos(x - b0, y, z - b1)).getBlock() == Blocks.air) {
				x -= b0;
				z -= b1;

			}
			int l;
			int i1;
			for (l = -1; l <= 2; ++l) {
				for (i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
						Block j1 = world.getBlockState(
								new BlockPos(x + b0 * l, y + i1, z + b1 * l))
								.getBlock();
						if (flag) {
							if (j1 != MageBlocks.witherCore) {
								return false;
							}
						} else if (j1 != Blocks.air && j1 != Blocks.fire) {
							return false;
						}
					}
				}
			}
			for (l = 0; l < 2; ++l) {
				for (i1 = 0; i1 < 3; ++i1) {
					world.setBlockState(
							new BlockPos(x + b0 * l, y + i1, z + b1 * l),
							(IBlockState) MageBlocks.witherCore.getBlockState(),
							i1);
				}
			}
			return true;
		}
	}
}
