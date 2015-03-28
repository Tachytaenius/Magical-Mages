package wolfboyft.magicalmages.misc;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import wolfboyft.magicalmages.MagicalMages;

public class _wolfboyftUtils {
	public static int mobID = 6755, projectileID = 7755, entityListID = 8755;

	public static void registerBossMob(Class entityClass, String entityName) {
		EntityRegistry.registerModEntity(entityClass, entityName, mobID++,
				MagicalMages.instance, 128, 5, true);
		EntityList.addMapping(entityClass, entityName, entityListID++,
				0x000000, 0x9B0000);
	}
}
