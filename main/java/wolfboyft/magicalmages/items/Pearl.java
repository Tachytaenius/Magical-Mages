package wolfboyft.magicalmages.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.entity.projectile.actual.FarlanderPearl;

public class Pearl extends Item {
	private static final String __OBFID = "CL_00000027";

	public Pearl() {
		this.maxStackSize = 16;
		this.setCreativeTab(MagicalMages.tabMod);
	}

	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn,
			EntityPlayer playerIn) {
		if (playerIn.capabilities.isCreativeMode) {
			return itemStackIn;
		} else {
			--itemStackIn.stackSize;
			worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

			if (!worldIn.isRemote) {
				worldIn.spawnEntityInWorld(new FarlanderPearl(worldIn, playerIn));
			}
			return itemStackIn;
		}
	}
}