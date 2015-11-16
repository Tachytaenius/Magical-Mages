package wolfboyft.magicalmages.entity.projectile.actual;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WitherBolt extends BaseProjectile {

	public WitherBolt(World var1) {
		super(var1);
	}

	public WitherBolt(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3, dam);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		for (int i = 0; i < 6; ++i) {
		}
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if (var1.entityHit != null) {
			if (!(var1.entityHit instanceof EntityLivingBase)) {
				this.setDead();
				worldObj.removeEntity(this);
				return;
			} else {
				if (var1.entityHit == getThrower()) {
					this.setDead();
					worldObj.removeEntity(this);
					return;
				}
				var1.entityHit.attackEntityFrom(
						DamageSource.causeThrownDamage(this, getThrower()),
						getDamage());
				if (!worldObj.isRemote) {
					this.setDead();
					((EntityLivingBase) var1.entityHit)
							.addPotionEffect(new PotionEffect(Potion.wither.id,
									200));
				}
			}
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0.3F;
	}
}