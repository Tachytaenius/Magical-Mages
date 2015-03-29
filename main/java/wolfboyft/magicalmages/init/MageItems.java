package wolfboyft.magicalmages.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.Reference;
import wolfboyft.magicalmages.entity.projectile.actual.Kunai;
import wolfboyft.magicalmages.entity.projectile.actual.MagicKunai;
import wolfboyft.magicalmages.entity.projectile.actual.MagicShuriken;
import wolfboyft.magicalmages.entity.projectile.actual.Shuriken;
import wolfboyft.magicalmages.entity.projectile.actual.WitherBolt;
import wolfboyft.magicalmages.misc.EnumArmour;
import wolfboyft.magicalmages.misc.Staves;
import wolfboyft.magicalmages.misc.ThrowableWeapon;

public class MageItems {
	public static final Item staffWither = new Staves("staffWither", 1000, 7,
			false, WitherBolt.class);
	public static final Item witherBone = new Item().setUnlocalizedName(
			"witherBone").setCreativeTab(MagicalMages.tabMod);
	public static final Item witherRib = new Item().setUnlocalizedName(
			"witherRib").setCreativeTab(MagicalMages.tabMod);
	public static final Item shuriken = new ThrowableWeapon("shuriken", 5,
			Shuriken.class);
	public static final Item kunai = new ThrowableWeapon("kunai", 4,
			Kunai.class);
	public static final Item magicShuriken = new ThrowableWeapon(
			"magicShuriken", 20, MagicShuriken.class);
	public static final Item magicKunai = new ThrowableWeapon("magicKunai", 16,
			MagicKunai.class);
	public static Item witherHelmet;
	public static Item witherChest;
	public static Item witherLegs;
	public static Item witherBoots;
	public static Item ninjaHelmet;
	public static Item ninjaChest;
	public static Item ninjaLegs;
	public static Item ninjaBoots;

	public static void init() {
	}

	public static void register() {
		int HEAD = Armours.HEAD;
		int BODY = Armours.BODY;
		int LEGS = Armours.LEGS;
		int BOOTS = Armours.BOOTS;
		GameRegistry.registerItem(witherBone, witherBone.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(witherRib, witherRib.getUnlocalizedName()
				.substring(5));
		GameRegistry.addRecipe(new ItemStack(staffWither, 1), "CBC", " A ",
				" D ", 'A', witherBone, 'B', Items.nether_star, 'C', witherRib,
				'D', new ItemStack(Items.skull, 1, 1));
		GameRegistry.addRecipe(new ItemStack(shuriken, 8), "A A", " B ", "A A",
				'A', Items.flint, 'B', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(magicKunai, 8), "ACA", "CBC",
				"ACA", 'A', Items.diamond, 'B', kunai, 'C', Items.emerald);
		GameRegistry.addRecipe(new ItemStack(magicShuriken, 8), "ACA", "CBC",
				"ACA", 'A', Items.diamond, 'B', shuriken, 'C', Items.emerald);
		witherHelmet = new Armours(EnumArmour.WITHER, HEAD);
		witherChest = new Armours(EnumArmour.WITHER, BODY);
		witherLegs = new Armours(EnumArmour.WITHER, LEGS);
		witherBoots = new Armours(EnumArmour.WITHER, BOOTS);
		GameRegistry.addRecipe(new ItemStack(witherHelmet, 1), "AAA", "ABA",
				'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherChest, 1), "ABA", "AAA",
				"AAA", 'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherLegs, 1), "AAA", "ABA",
				"A A", 'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherBoots, 1), "ABA", "A A",
				'A', witherBone, 'B', Items.nether_star);
		ninjaHelmet = new Armours(EnumArmour.NINJA, HEAD);
		ninjaChest = new Armours(EnumArmour.NINJA, BODY);
		ninjaLegs = new Armours(EnumArmour.NINJA, LEGS);
		ninjaBoots = new Armours(EnumArmour.NINJA, BOOTS);
	}

	public static void registerRenders() {
		registerRender(staffWither);
		registerRender(witherBone);
		registerRender(witherRib);
		registerRender(shuriken);
		registerRender(kunai);
		registerRender(magicShuriken);
		registerRender(magicKunai);
		registerRender(witherHelmet);
		registerRender(witherChest);
		registerRender(witherLegs);
		registerRender(witherBoots);
		registerRender(ninjaHelmet);
		registerRender(ninjaChest);
		registerRender(ninjaLegs);
		registerRender(ninjaBoots);
	}

	public static void registerRender(Item item) {
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
