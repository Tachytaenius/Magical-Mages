package wolfboyft.magicalmages.misc;

import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHooks {
	@SubscribeEvent
	public void LivingDropEvent(LivingDropsEvent event){
		if(event.entity instanceof EntityWither){
			event.drops.clear();
			event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(Items.nether_star, 14)));
			if (event.entityLiving.isBurning()){
				event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(Items.diamond, 6)));
			}else{
				event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(Items.golden_apple, 6)));
				}
			}
		
		if(event.entity instanceof EntitySkeleton){
			if(true){
			event.drops.clear();
			event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(Items.nether_star, 14)));
			if (event.entityLiving.isBurning()){
				event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(Items.diamond, 6)));
			}else{
				event.drops.add(new EntityItem(event.entityLiving.worldObj,event.entityLiving.posX,event.entityLiving.posY,event.entityLiving.posZ,new ItemStack(Items.golden_apple, 6)));
				}
			}
		}
	}
}