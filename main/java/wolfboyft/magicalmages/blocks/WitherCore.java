package wolfboyft.magicalmages.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import wolfboyft.magicalmages.init.MageBlocks;

public class WitherCore extends Block {

	public WitherCore(Material materialIn) {
		super(materialIn);
		this.setResistance(6);
		this.setHardness(2.5F);
		this.setStepSound(this.soundTypeStone);
	}

	public Block drop(int i, Random rand, int j) {
		return MageBlocks.witherCore;
	}

	public int qauntityDropped() {
		return 1;

	}
}
