package wolfboyft.magicalmages;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wolfboyft.magicalmages.init.MageItems;

public class ModTabMM extends CreativeTabs {

	public ModTabMM(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return MageItems.staffWither;
	}
}
