package wolfboyft.magicalmages.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import wolfboyft.magicalmages.entity.mob.enemy.actual.WitherGuardian;
import wolfboyft.magicalmages.entity.mob.enemy.render.RenderWitherGuardian;
import wolfboyft.magicalmages.entity.mob.passive.actual.Farlanderman;
import wolfboyft.magicalmages.entity.mob.passive.render.RenderFarlanderman;
import wolfboyft.magicalmages.entity.projectile.actual.ExcaliburBeam;
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
		RenderingRegistry.registerEntityRenderingHandler(ExcaliburBeam.class,
				new RenderBaseProjectile(new ResourceLocation(
						"magicalmages:textures/misc/excalibur_zap.png"), 4F,
						1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(WitherGuardian.class,
				new RenderWitherGuardian(Minecraft.getMinecraft()
						.getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(Farlanderman.class,
				new RenderFarlanderman(Minecraft.getMinecraft()
						.getRenderManager()));
	}

}