package wolfboyft.magicalmages.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.Reference;
import wolfboyft.magicalmages.entity.projectile.actual.WitherBolt;
import wolfboyft.magicalmages.misc.Staves;

public class MageItems {
	public static final Item staffWither = new Staves("staffWither", 0, 7, true, WitherBolt.class);
	public static final Item witherBone = new Item().setUnlocalizedName("witherBone").setCreativeTab(MagicalMages.tabMod);
	public static final Item witherRib = new Item().setUnlocalizedName("witherRib").setCreativeTab(MagicalMages.tabMod);
	
	public static void init(){
	}
	
	public static void register(){
		GameRegistry.registerItem(staffWither, staffWither.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(witherBone, witherBone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(witherRib, witherRib.getUnlocalizedName().substring(5));
		GameRegistry.addRecipe(new ItemStack(staffWither, 1), 
		    	"CBC",
		    	" A ",
		    	" D ",
		    	'A', witherBone, 'B', Items.nether_star, 'C', witherRib, 'D', new ItemStack(Items.skull, 1, 1)
		);
	}
	
	public static void registerRenders(){
		registerRender(staffWither);
		registerRender(witherBone);
		registerRender(witherRib);
	}
	
	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}