package wolfboyft.magicalmages.proxy;

import wolfboyft.magicalmages.entity.mob.boss.actual.HallowMaster;
import wolfboyft.magicalmages.misc._wolfboyftUtils;

public class CommonProxy {
	public void registerRenders() {
		_wolfboyftUtils.registerBossMob(HallowMaster.class, "hallowMaster");
	}
}
