package wolfboyft.magicalmages.items;

import net.minecraft.item.Item;
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
}
