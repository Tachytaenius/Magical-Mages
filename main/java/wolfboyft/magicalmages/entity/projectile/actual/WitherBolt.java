package wolfboyft.magicalmages.entity.projectile.actual;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class WitherBolt extends BaseProjectile{

	public WitherBolt(World var1) {
		super(var1);
	}
	
	public WitherBolt(World var1, EntityLivingBase var3, float dam) {
		super(var1, var3, dam);
	}
	
	@Override
	public void onUpdate() {
		Random rand = new Random();
		super.onUpdate();
		for(int i = 0; i < 20; ++i) {
		}
	}
	
	@Override
	protected void onImpact(MovingObjectPosition var1) {
		if(var1.entityHit != null) {
			if(var1.entityHit == getThrower()){
				
			}else{
				
			var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), getDamage());
			 ((EntityLivingBase)var1.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
			}
		}
		if(!worldObj.isRemote) this.setDead();
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0.032F;
	}
}