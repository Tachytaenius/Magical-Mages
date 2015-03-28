package wolfboyft.magicalmages.misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.entity.projectile.actual.BaseProjectile;

public class ThrowableWeapon extends ModItemHelper {

	protected int usage;
	protected int damage;
	protected boolean unBreakable;
	protected Class<? extends BaseProjectile> projectile;

	public ThrowableWeapon(String name, int dam,
			Class<? extends BaseProjectile> projectile) {
		super(name);
		this.projectile = projectile;
		damage = dam;
		setMaxStackSize(64);
		setCreativeTab(MagicalMages.tabMod);
		setUnlocalizedName(name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		try {
			player.swingItem();
			world.spawnEntityInWorld(projectile.getConstructor(World.class,
					EntityLivingBase.class, float.class).newInstance(world,
					player, damage));
			if (!(player.capabilities.isCreativeMode)) {
				--stack.stackSize;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stack;
	}

	public void onUpdate() {

	}
}