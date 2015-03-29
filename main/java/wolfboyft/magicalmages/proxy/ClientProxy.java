package wolfboyft.magicalmages.proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import wolfboyft.magicalmages.entity.projectile.actual.Kunai;
import wolfboyft.magicalmages.entity.projectile.actual.MagicKunai;
import wolfboyft.magicalmages.entity.projectile.actual.MagicShuriken;
import wolfboyft.magicalmages.entity.projectile.actual.Shuriken;
import wolfboyft.magicalmages.entity.projectile.actual.WitherBolt;
import wolfboyft.magicalmages.entity.projectile.render.RenderBaseProjectile;
import wolfboyft.magicalmages.init.MageBlocks;
import wolfboyft.magicalmages.init.MageItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders() {
		MageItems.registerRenders();
		MageBlocks.RegisterRenders();
		RenderingRegistry.registerEntityRenderingHandler(WitherBolt.class,
				new RenderBaseProjectile(new ResourceLocation(
						"magicalmages:textures/misc/WitherBolt.png"), 1F, 1F,
						1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(Shuriken.class,
				new RenderBaseProjectile(new ResourceLocation(
						"magicalmages:textures/misc/shuriken.png"), 1F, 1F, 1F,
						1F));
		RenderingRegistry
				.registerEntityRenderingHandler(Kunai.class,
						new RenderBaseProjectile(new ResourceLocation(
								"magicalmages:textures/misc/kunai.png"), 1F,
								1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(MagicShuriken.class,
				new RenderBaseProjectile(new ResourceLocation(
						"magicalmages:textures/misc/magicShuriken.png"), 5F,
						1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(MagicKunai.class,
				new RenderBaseProjectile(new ResourceLocation(
						"magicalmages:textures/misc/magicKunai.png"), 4F, 1F,
						1F, 1F));
	}

}