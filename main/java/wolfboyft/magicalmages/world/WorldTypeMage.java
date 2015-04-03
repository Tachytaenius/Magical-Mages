package wolfboyft.magicalmages.world;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeMage extends WorldType {
	public WorldTypeMage(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer,
			String chunkProviderSettingsJson) {
		GenLayer ret = new MageGenLayerBiome(200L, parentLayer, this,
				chunkProviderSettingsJson);
		ret = GenLayerZoom.magnify(1000L, ret, 2);
		ret = new GenLayerBiomeEdge(1000L, ret);
		return ret;
	}
}
