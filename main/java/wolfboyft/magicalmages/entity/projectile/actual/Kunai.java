package wolfboyft.magicalmages.entity.projectile.actual;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wolfboyft.magicalmages.init.MageItems;

public class Kunai extends BaseProjectile {

	public Kunai(World var1) {
		super(var1);
	}

	public Kunai(World var1, EntityLivingBase var3, float dam) {
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
				}
			}
		}

		if (var1.typeOfHit.BLOCK != null) {
			boolean collect = Math.random() > 0.5;
			this.setDead();
			this.playSound("dig.stone", 1, 2);
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.kunai) });
			this.playSound("dig.stone", 1, 2);
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.kunai) });
			this.playSound("dig.stone", 1, 2);
			this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK,
					this.posX, this.posY, this.posZ,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					((double) this.rand.nextFloat() - 0.5D) * 0.08D,
					new int[] { Item.getIdFromItem(MageItems.kunai) });
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0.04F;
	}
}
