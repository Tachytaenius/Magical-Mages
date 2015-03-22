package wolfboyft.magicalmages.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import wolfboyft.magicalmages.entity.mob.boss.actual.HallowMaster;
import wolfboyft.magicalmages.entity.mob.boss.render.RenderHallowMaster;
import wolfboyft.magicalmages.entity.projectile.actual.WitherBolt;
import wolfboyft.magicalmages.entity.projectile.render.RenderBaseProjectile;
import wolfboyft.magicalmages.init.MageItems;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders() {;
		MageItems.registerRenders();
		RenderingRegistry.registerEntityRenderingHandler(WitherBolt.class, new RenderBaseProjectile(new ResourceLocation("magicalmages:textures/misc/WitherBolt.png"), 1F, 1F, 1F, 1F));
		RenderingRegistry.registerEntityRenderingHandler(HallowMaster.class, new RenderHallowMaster(Minecraft.getMinecraft().getRenderManager()));
		}
}