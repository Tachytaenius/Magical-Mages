package wolfboyft.magicalmages;

import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import com.iTooly.survivaltabs.api.SurvivalTabs;

public class ModTabSurvival extends SurvivalTabs {

	public ModTabSurvival(String lable, ResourceLocation guiTexture) {
		super(lable, guiTexture);

		this.addPlayer(51, 75, 30);
	}

	@Override
	public Item getTabIconItem() {
		return Items.enchanted_book;
	}

	@Override
	public Container getContainer() {
		return new ContainerPlayer(mc.thePlayer.inventory,
				!mc.theWorld.isRemote, mc.thePlayer);
	}

}
