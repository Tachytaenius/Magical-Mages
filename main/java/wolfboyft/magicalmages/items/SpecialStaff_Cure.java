package wolfboyft.magicalmages.items;

import net.minecraft.item.Item;
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
}
