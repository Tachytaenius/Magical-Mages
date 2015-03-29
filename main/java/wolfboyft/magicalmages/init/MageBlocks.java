package wolfboyft.magicalmages.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.Reference;
import wolfboyft.magicalmages.blocks.WitherCore;

public class MageBlocks {

	public static Block witherCore;

	public static void init() {
		witherCore = new WitherCore(Material.iron).setUnlocalizedName(
				"witherCore").setCreativeTab(MagicalMages.tabMod);
	}

	public static void register() {
		GameRegistry.registerBlock(witherCore, witherCore.getUnlocalizedName()
				.substring(5));
		GameRegistry.addRecipe(new ItemStack(witherCore, 1), "AAA", "AAA",
				"AAA", 'A', Items.nether_star);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.nether_star, 9),
				new Object[] { new ItemStack(witherCore) });
	}

	public static void RegisterRenders() {
		RegisterRender(witherCore);
	}

	public static void RegisterRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(
						item,
						0,
						new ModelResourceLocation(Reference.MOD_ID + ":"
								+ item.getUnlocalizedName().substring(5),
								"inventory"));
	}
}
