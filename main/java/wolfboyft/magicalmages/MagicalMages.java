package wolfboyft.magicalmages;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import wolfboyft.magicalmages.dimension.witherlands.WorldProviderWitherlands;
import wolfboyft.magicalmages.init.MageBlocks;
import wolfboyft.magicalmages.init.MageItems;
import wolfboyft.magicalmages.misc.EventHooks;
import wolfboyft.magicalmages.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MagicalMages {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static MagicalMages instance;
	public static final ModTab tabMod = new ModTab("tabMod");
	public static int dimensionId = 273;

	EventHooks eventhooksVar = new EventHooks();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Sytheren was here
		MageItems.init();
		MageItems.register();
		MageBlocks.init();
		MageBlocks.register();
		MinecraftForge.EVENT_BUS.register(eventhooksVar);
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
		DimensionManager.registerProviderType(dimensionId,
				WorldProviderWitherlands.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
	}
}
