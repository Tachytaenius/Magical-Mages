package wolfboyft.magicalmages;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import wolfboyft.magicalmages.entity.mob.enemy.RegisterEnemyEntities;
import wolfboyft.magicalmages.init.MageBlocks;
import wolfboyft.magicalmages.init.MageItems;
import wolfboyft.magicalmages.misc.EventHooks;
import wolfboyft.magicalmages.proxy.CommonProxy;
import wolfboyft.magicalmages.world.WorldTypeMage;
import wolfboyft.magicalmages.world.biome.witherlands.BiomeRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MagicalMages {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static MagicalMages instance;
	public static final ModTabMM tabModMM = new ModTabMM("magestabModMM");

	EventHooks eventhooksVar = new EventHooks();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Sytheren was here
		// Lol, wolfboyft was here too!
		MageItems.init();
		MageItems.register();
		MageBlocks.init();
		MageBlocks.register();
		MinecraftForge.EVENT_BUS.register(eventhooksVar);
		MinecraftForge.TERRAIN_GEN_BUS.register(eventhooksVar);
		RegisterEnemyEntities.mainRegistry();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
		BiomeRegistry.mainRegistry();
		final WorldType MAGE = new WorldTypeMage("mage");
		oreRegistration();
		registerOreRecipes();
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {

	}

	public static void oreRegistration() {
	}

	private void registerOreRecipes() {

	}

}
