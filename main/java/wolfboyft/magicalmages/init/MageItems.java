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
			false, WitherBolt.class).setMaxDamage(1000).setMaxStackSize(64)
			.setCreativeTab(MagicalMages.tabMod)
			.setUnlocalizedName("staffWither");
	public static final Item witherBone = new Item().setUnlocalizedName(
			"witherBone").setCreativeTab(MagicalMages.tabMod);
	public static final Item witherRib = new Item().setUnlocalizedName(
			"witherRib").setCreativeTab(MagicalMages.tabMod);
	public static final Item shuriken = new ThrowableWeapon("shuriken", 5,
			Shuriken.class).setMaxStackSize(64)
			.setCreativeTab(MagicalMages.tabMod).setUnlocalizedName("shuriken");
	public static final Item kunai = new ThrowableWeapon("kunai", 4,
			Kunai.class).setMaxStackSize(64)
			.setCreativeTab(MagicalMages.tabMod).setUnlocalizedName("kunai");
	public static final Item magicShuriken = new ThrowableWeapon(
			"magicShuriken", 20, MagicShuriken.class).setMaxStackSize(64)
			.setCreativeTab(MagicalMages.tabMod)
			.setUnlocalizedName("magicShuriken");
	public static final Item magicKunai = new ThrowableWeapon("magicKunai", 16,
			MagicKunai.class).setMaxStackSize(64)
			.setCreativeTab(MagicalMages.tabMod)
			.setUnlocalizedName("magicKunai");
	public static Item witherHelmet;
	public static Item witherChest;
	public static Item witherLegs;
	public static Item witherBoots;
	public static Item ninjaHelmet;
	public static Item ninjaChest;
	public static Item ninjaLegs;
	public static Item ninjaBoots;

	public static void init() {
		int HEAD = Armours.HEAD;
		int BODY = Armours.BODY;
		int LEGS = Armours.LEGS;
		int BOOTS = Armours.BOOTS;
		witherHelmet = new Armours(EnumArmour.WITHER, HEAD).setUnlocalizedName(
				"witherHelmet").setCreativeTab(MagicalMages.tabMod);
		witherChest = new Armours(EnumArmour.WITHER, BODY).setUnlocalizedName(
				"witherBody").setCreativeTab(MagicalMages.tabMod);
		witherLegs = new Armours(EnumArmour.WITHER, LEGS).setUnlocalizedName(
				"witherLegs").setCreativeTab(MagicalMages.tabMod);
		witherBoots = new Armours(EnumArmour.WITHER, BOOTS).setUnlocalizedName(
				"witherBoots").setCreativeTab(MagicalMages.tabMod);
		ninjaHelmet = new Armours(EnumArmour.NINJA, HEAD).setUnlocalizedName(
				"ninjaHelmet").setCreativeTab(MagicalMages.tabMod);
		ninjaChest = new Armours(EnumArmour.NINJA, BODY).setUnlocalizedName(
				"ninjaBody").setCreativeTab(MagicalMages.tabMod);
		ninjaLegs = new Armours(EnumArmour.NINJA, LEGS).setUnlocalizedName(
				"ninjaLegs").setCreativeTab(MagicalMages.tabMod);
		ninjaBoots = new Armours(EnumArmour.NINJA, BOOTS).setUnlocalizedName(
				"ninjaBoots").setCreativeTab(MagicalMages.tabMod);
	}

	public static void register() {
		GameRegistry.registerItem(witherBone, witherBone.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(witherRib, witherRib.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(shuriken, shuriken.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(kunai, kunai.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(magicShuriken, magicShuriken
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(magicKunai, magicKunai.getUnlocalizedName()
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
		GameRegistry.addRecipe(new ItemStack(witherHelmet, 1), "AAA", "ABA",
				'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherChest, 1), "ABA", "AAA",
				"AAA", 'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherLegs, 1), "AAA", "ABA",
				"A A", 'A', witherBone, 'B', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(witherBoots, 1), "ABA", "A A",
				'A', witherBone, 'B', Items.nether_star);
		GameRegistry.registerItem(ninjaHelmet, ninjaHelmet.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(ninjaChest, ninjaChest.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(ninjaLegs, ninjaLegs.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(ninjaBoots, ninjaBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(witherHelmet, witherHelmet
				.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(witherChest, witherChest.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(witherBoots, witherBoots.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(witherLegs, witherLegs.getUnlocalizedName()
				.substring(5));
		GameRegistry.registerItem(staffWither, staffWither.getUnlocalizedName()
				.substring(5));
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
