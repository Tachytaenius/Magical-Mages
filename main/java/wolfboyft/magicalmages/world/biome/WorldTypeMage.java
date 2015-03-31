package wolfboyft.magicalmages.world.biome;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeMage extends WorldType {

	public WorldTypeMage(int par1, String name) {
		super(name);
	}

	public GenLayer getBiomeLayer(long WorldSeed, GenLayer parentLayer) {
		GenLayer ret = new MageGenLayerBiome(200L, parentLayer, this);
		ret = GenLayerZoom.magnify(1000L, ret, 2);
		ret = new GenLayerBiomeEdge(1000L, ret);
		return ret;

	}

}
