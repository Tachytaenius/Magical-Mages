package wolfboyft.magicalmages.misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.entity.projectile.actual.BaseProjectile;

public class Staves extends ModItemHelper {

	protected int usage;
	protected int damage;
	protected boolean unBreakable;
	protected Class<? extends BaseProjectile> projectile; 
	
	public Staves(String name, int uses, int dam, boolean unbreakable, Class<? extends BaseProjectile> projectile) {
		super(name);
		this.projectile = projectile;
		damage = dam;
		this.unBreakable = unbreakable;
		setMaxDamage(uses);
		setMaxStackSize(1);
		setCreativeTab(MagicalMages.tabMod);
		setUnlocalizedName(name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
			try {
				if(!world.isRemote) {
						world.spawnEntityInWorld(projectile.getConstructor(World.class, EntityLivingBase.class, float.class).newInstance(world, player, damage));
						stack.damageItem(1, player);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return stack;
	}
}