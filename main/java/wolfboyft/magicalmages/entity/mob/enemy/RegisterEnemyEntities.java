package wolfboyft.magicalmages.entity.mob.enemy;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import wolfboyft.magicalmages.Reference;
import wolfboyft.magicalmages.entity.mob.enemy.actual.WitherGuardian;

public class RegisterEnemyEntities {

	public static void mainRegistry() {
		registerEntity();
	}

	public static void registerEntity() {

		createEntity(WitherGuardian.class, "Wither Guardian", 0x101010,
				0x250000);

	}

	public static void createEntity(Class entityClass, String entityName,
			int solidColor, int spotColor) {
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry
				.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId,
				Reference.MOD_ID, 64, 1, true);

		createEgg(randomId, solidColor, spotColor);

	}

	private static void createEgg(int randomId, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId),
				new EntityList.EntityEggInfo(randomId, solidColor, spotColor));

	}

}