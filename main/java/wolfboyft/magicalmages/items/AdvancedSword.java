package wolfboyft.magicalmages.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;
import wolfboyft.magicalmages.entity.projectile.actual.BaseProjectile;

public class AdvancedSword extends ItemSword {

	public float attackDamage;
	public final Item.ToolMaterial material;
	public int damage;
	public boolean unbreakable;
	public Class<? extends BaseProjectile> projectile;
	public boolean firesprojectile;

	public AdvancedSword(ToolMaterial material, String name,
			Class<? extends BaseProjectile> projectile,
			boolean firesprojectile, boolean unbreakable) {
		super(material);
		this.material = material;
		this.projectile = projectile;
		this.maxStackSize = 1;
		this.setMaxDamage(material.getMaxUses());
		this.setCreativeTab(MagicalMages.tabMod);
		this.attackDamage = 4.0F + material.getDamageVsEntity();
		GameRegistry.registerItem(this, name);
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
				if (unbreakable != true) {
					stack.damageItem(1, player);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stack;
	}
}
