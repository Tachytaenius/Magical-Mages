package wolfboyft.magicalmages.proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import wolfboyft.magicalmages.entity.misc.render.EntityRender;
import wolfboyft.magicalmages.entity.projectile.actual.WitherBolt;
import wolfboyft.magicalmages.entity.projectile.model.Bolt;
import wolfboyft.magicalmages.init.MageItems;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders() {;
		MageItems.registerRenders();
		RenderingRegistry.registerEntityRenderingHandler(WitherBolt.class, new EntityRender(new Bolt(), 0.5F, new ResourceLocation("magicalmages:textures/entity/projectile/WitherBolt.png")));
	}
}