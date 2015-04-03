package wolfboyft.magicalmages.misc;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wolfboyft.magicalmages.entity.mob.enemy.actual.WitherGuardian;
import wolfboyft.magicalmages.init.MageItems;

public class EventHooks {
	@SubscribeEvent
	public void LivingDropEvent(LivingDropsEvent event) {
		if (event.entity instanceof EntityWither) {
			event.drops.clear();
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(Items.nether_star,
							14)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(Items.diamond, 6)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(Items.golden_apple,
							6)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(MageItems.witherRib,
							6)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(
							MageItems.witherBone, 13)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(Items.skull, 2, 1)));
		}
		if (event.entity instanceof WitherGuardian) {
			event.drops.clear();
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(MageItems.witherRib,
							6)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(
							MageItems.witherBone, 13)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(MageItems.witherRib,
							6)));
			event.drops.add(new EntityItem(event.entityLiving.worldObj,
					event.entityLiving.posX, event.entityLiving.posY,
					event.entityLiving.posZ, new ItemStack(Blocks.prismarine,
							2, 2)));
		}
	}
}