package wolfboyft.magicalmages.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;

public class SpecialStaff_Cure extends Item {
	public SpecialStaff_Cure(String name, int uses) {
		setCreativeTab(MagicalMages.tabMod);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		setMaxDamage(uses);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if(){
			
			stack.damageItem(1, player);
		}
		
		return stack;
	}
}
