package wolfboyft.magicalmages.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;

public class DimensionalTransit extends Item {

	public DimensionalTransit(String name, int uses, int dimension) {
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(MagicalMages.tabMod);
		setMaxDamage(uses);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		player.mcServer.getConfigurationManager().transferPlayerToDimension(
				player,
				MagicalMages.dimensionId,
				new TeleporterWitherlands(mServer
						.worldServerForDimension(MagicalMages.dimensionId)));
		return stack;
	}
}
