package wolfboyft.magicalmages.entity.mob.passive.render;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wolfboyft.magicalmages.entity.mob.passive.actual.Farlanderman;
import wolfboyft.magicalmages.entity.mob.passive.render.layer.LayerFarlandermanEyes;
import wolfboyft.magicalmages.entity.mob.passive.render.layer.LayerHeldBlockFarlanderman;

@SideOnly(Side.CLIENT)
public class RenderFarlanderman extends RenderLiving {
	private static final ResourceLocation endermanTextures = new ResourceLocation(
			"textures/entity/enderman/enderman.png");
	private ModelEnderman endermanModel;
	private Random rnd = new Random();
	private static final String __OBFID = "CL_00000989";

	public RenderFarlanderman(RenderManager p_i46182_1_) {
		super(p_i46182_1_, new ModelEnderman(0.0F), 0.5F);
		this.endermanModel = (ModelEnderman) super.mainModel;
		this.addLayer(new LayerFarlandermanEyes(this));
		this.addLayer(new LayerHeldBlockFarlanderman(this));
	}

	public void doRender(Farlanderman entity, double x, double y, double z,
			float p_76986_8_, float partialTicks) {
		this.endermanModel.isCarrying = entity.func_175489_ck().getBlock()
				.getMaterial() != Material.air;
		this.endermanModel.isAttacking = entity.isScreaming();

		if (entity.isScreaming()) {
			double d3 = 0.02D;
			x += this.rnd.nextGaussian() * d3;
			z += this.rnd.nextGaussian() * d3;
		}

		super.doRender((EntityLiving) entity, x, y, z, p_76986_8_, partialTicks);
	}

	protected ResourceLocation func_180573_a(Farlanderman p_180573_1_) {
		return endermanTextures;
	}

	public void doRender(EntityLiving entity, double x, double y, double z,
			float p_76986_8_, float partialTicks) {
		this.doRender((Farlanderman) entity, x, y, z, p_76986_8_, partialTicks);
	}

	public void doRender(EntityLivingBase entity, double x, double y, double z,
			float p_76986_8_, float partialTicks) {
		this.doRender((Farlanderman) entity, x, y, z, p_76986_8_, partialTicks);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.func_180573_a((Farlanderman) entity);
	}

	public void doRender(Entity entity, double x, double y, double z,
			float p_76986_8_, float partialTicks) {
		this.doRender((Farlanderman) entity, x, y, z, p_76986_8_, partialTicks);
	}
}