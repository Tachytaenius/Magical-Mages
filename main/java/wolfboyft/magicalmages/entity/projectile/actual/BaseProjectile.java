package wolfboyft.magicalmages.entity.projectile.actual;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BaseProjectile extends EntityThrowable {

	public float damage;

	public BaseProjectile(World var1) {
		super(var1);
	}

	public <AccelerationX> BaseProjectile(World var1, EntityLivingBase var3,
			float dam) {
		super(var1, var3);
		damage = dam;
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	@Override
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
	}

	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if (var1.entityHit != null)
			var1.entityHit.attackEntityFrom(
					DamageSource.causeThrownDamage(this, getThrower()), damage);
		if (!worldObj.isRemote)
			this.setDead();
	}

	protected float getGravityVelocity() {
		return 0.01F;
	}
}