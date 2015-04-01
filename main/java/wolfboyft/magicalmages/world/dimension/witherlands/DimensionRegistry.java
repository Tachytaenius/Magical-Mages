package wolfboyft.magicalmages.world.dimension.witherlands;

import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry {

	public static void mainRegistry() {
		registerDimension();
	}

	public static final int dimensionId = 25;

	private static void registerDimension() {
		DimensionManager.registerProviderType(dimensionId,
				WorldProviderWitherlands.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
	}
}
