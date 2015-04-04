package wolfboyft.magicalmages.entity.mob.passive;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import wolfboyft.magicalmages.Reference;
import wolfboyft.magicalmages.entity.mob.passive.actual.Farlanderman;

public class RegisterPassiveEntities {

	public static void mainRegistry() {
		registerEntity();
	}

	public static void registerEntity() {

		createEntity(Farlanderman.class, "Farlanderman", 0x101010, 0x002500);

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