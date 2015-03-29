package wolfboyft.magicalmages;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import wolfboyft.magicalmages.init.MageBlocks;
import wolfboyft.magicalmages.init.MageItems;
import wolfboyft.magicalmages.misc.EventHooks;
import wolfboyft.magicalmages.proxy.CommonProxy;

import com.iTooly.survivaltabs.api.SurvivalTabs;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class MagicalMages {
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static MagicalMages instance;
	public static final ModTab tabMod = new ModTab("tabMod");
	public static final SurvivalTabs inventoryTab = new ModTabSurvival(
			"inventory", new ResourceLocation(
					"textures/gui/container/inventory.png"));

	EventHooks eventhooksVar = new EventHooks();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MageItems.init();
		MageItems.register();
		MageBlocks.init();
		MageBlocks.register();
		MinecraftForge.EVENT_BUS.register(eventhooksVar);
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
	}
}