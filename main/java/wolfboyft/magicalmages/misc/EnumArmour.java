package wolfboyft.magicalmages.misc;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public enum EnumArmour {

	WITHER(ModItemHelper.addArmorMaterial("wither", 1000, new int[] { 4, 8, 6,
			4 }, 20), "wither", false, 75, Items.nether_star),

	NINJA(ModItemHelper.addArmorMaterial("ninja", 250,
			new int[] { 2, 4, 3, 2 }, 20), "ninja", false, 35, Blocks.wool);

	private ArmorMaterial armorMaterial;
	private String type;
	private boolean undamageable;
	private int damageReduction;
	private Item repairItem;

	private EnumArmour(ArmorMaterial armorMaterial, String type,
			boolean undamageable, int damageReduction, Item repair) {
		this.armorMaterial = armorMaterial;
		this.type = type;
		this.undamageable = undamageable;
		this.damageReduction = damageReduction;
		this.repairItem = repair;
	}

	private EnumArmour(ArmorMaterial armorMaterial, String type,
			boolean undamageable, int damageReduction, Block repair) {
		this.armorMaterial = armorMaterial;
		this.type = type;
		this.undamageable = undamageable;
		this.damageReduction = damageReduction;
		this.repairItem = ModItemHelper.toItem(repair);
	}

	public Item getRepairItem() {
		return repairItem;
	}

	public ArmorMaterial getArmorMaterial() {
		return armorMaterial;
	}

	public String getType() {
		return type;
	}

	public boolean isUndamageable() {
		return undamageable;
	}

	public int getDamageReduction() {
		return damageReduction;
	}
}