package wolfboyft.magicalmages.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import wolfboyft.magicalmages.init.MageBlocks;

public class WitherMoss extends Block {

	public WitherMoss(Material materialIn) {
		super(materialIn);
		this.setResistance(3);
		this.setHardness(1.25F);
		this.setStepSound(this.soundTypeStone);
	}

	public Block drop(int i, Random rand, int j) {
		return MageBlocks.witherMoss;
	}

	public int qauntityDropped() {
		return 1;

	}
}
