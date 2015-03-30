package wolfboyft.magicalmages.misc;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.entity.projectile.actual.BaseProjectile;

public class Staves extends Item {

	protected int usage;
	protected int damage;
	protected boolean unBreakable;
	protected Class<? extends BaseProjectile> projectile;

	public Staves(String name, int uses, int dam, boolean unbreakable,
			Class<? extends BaseProjectile> projectile) {
		super();
		this.projectile = projectile;
		damage = dam;
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(MagicalMages.tabMod);
		setMaxDamage(uses);
		GameRegistry.registerItem(this, name);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		player.swingItem();
		player.setItemInUse(stack, 3);
		try {
			world.spawnEntityInWorld(projectile.getConstructor(World.class,
					EntityLivingBase.class, float.class).newInstance(world,
					player, damage));
			stack.damageItem(1, player);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return stack;
	}
}
