package wolfboyft.magicalmages.misc;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wolfboyft.magicalmages.MagicalMages;

public class ModItemHelper extends Item {

	protected int healAmount = 0;

	public ModItemHelper(String name) {
		this(name, MagicalMages.tabMod);
	}

	public ModItemHelper(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setCreativeTab(tab);
		GameRegistry.registerItem(this, name);
	}

	public ModItemHelper setHealAmount(int healAmount) {
		this.healAmount = healAmount;
		return this;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (healAmount != 0) {
			if (player.getHealth() < player.getMaxHealth()) {
				player.heal(healAmount);
				player.inventory.consumeInventoryItem(this);
			}
		}
		return stack;
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity,
			boolean magic, String sound, boolean damage, ItemStack item, int dam) {
		if (magic)
			w.spawnEntityInWorld(entity);
		if (magic) {
			if (damage)
				item.damageItem(dam, p);
		}
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity,
			String sound, boolean damage, ItemStack item, int dam) {
		w.spawnEntityInWorld(entity);
		if (damage)
			item.damageItem(dam, p);
	}

	public void spawnEntityIntoWorld(World w, EntityPlayer p, Entity entity,
			boolean magic, String sound) {
		spawnEntityIntoWorld(w, p, entity, magic, sound, false, new ItemStack(
				Items.apple), 0);
	}

	public static ArmorMaterial addArmorMaterial(String name, int durability,
			int[] oldArmor, int enchantability) {
		int duraNew = (int) Math.round(durability / 13.75);
		return EnumHelper.addArmorMaterial(name, name, duraNew, oldArmor,
				enchantability);
	}

	public static Item toItem(Block block) {
		return Item.getItemFromBlock(block);
	}
}
