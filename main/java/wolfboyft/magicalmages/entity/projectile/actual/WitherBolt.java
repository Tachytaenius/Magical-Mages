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
		for(int i = 0; i < 6; ++i) {
		}
	}
	
	 @Override
	 protected void onImpact(MovingObjectPosition var1) {
	  if(var1.entityHit != null) {
	   if(var1.entityHit == getThrower()){
	    
	   }else{
	    
	   var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), getDamage());
		if(!worldObj.isRemote) {
			worldObj.createExplosion(this, posX, posY, posZ, 1.0F, true);
			this.setDead();
			((EntityLivingBase)var1.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
				this.setDead();
			}
		}
	    }
	   
	  if(!worldObj.isRemote) this.setDead();
	 }
}