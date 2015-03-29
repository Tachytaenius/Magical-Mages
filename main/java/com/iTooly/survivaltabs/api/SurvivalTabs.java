package com.iTooly.survivaltabs.api;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class SurvivalTabs {
	public static SurvivalTabs[] survivalTabArray = new SurvivalTabs[1];
	public static Minecraft mc;

	public static final SurvivalTabs tabInventory = (new SurvivalTabs(0,
			"inventory", new ResourceLocation(
					"textures/gui/container/inventory.png")) {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.crafting_table);
		}

		@SideOnly(Side.CLIENT)
		public Container getContainer() {
			return new ContainerPlayer(mc.thePlayer.inventory,
					!mc.theWorld.isRemote, mc.thePlayer);
		}
	}).setBackgroundImageTexture(
			new ResourceLocation("textures/gui/container/inventory.png"))
			.addPlayer(51, 75, 30);;
	public final int tabIndex;
	public final String tabLabel;
	public ResourceLocation backgroundImageTexture = new ResourceLocation(
			"textures/gui/container/creative_inventory/items.png");
	public boolean drawTitle = true;
	@SideOnly(Side.CLIENT)
	public ItemStack itemIcon;
	public boolean isDrawPlayerNeeded = false;
	public int fromLeftSize;
	public int fromTheTop;
	public int scale;

	public SurvivalTabs(String lable, ResourceLocation guiTexture) {
		this(getNextID(), lable, guiTexture);
	}

	public SurvivalTabs(int id, String label, ResourceLocation guiTexture) {
		if (id >= survivalTabArray.length) {
			SurvivalTabs[] tmp = new SurvivalTabs[id + 1];
			for (int x = 0; x < survivalTabArray.length; x++) {
				tmp[x] = survivalTabArray[x];
			}
			survivalTabArray = tmp;
		}
		this.tabIndex = id;
		this.tabLabel = label;
		survivalTabArray[id] = this;
		this.setBackgroundImageTexture(guiTexture);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIndex() {
		return this.tabIndex;
	}

	public SurvivalTabs setBackgroundImageTexture(ResourceLocation texture) {
		this.backgroundImageTexture = texture;
		return this;
	}

	@SideOnly(Side.CLIENT)
	public String getTabLabel() {
		return this.tabLabel;
	}

	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel() {
		return "itemGroup." + this.getTabLabel();
	}

	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		if (this.itemIcon == null) {
			this.itemIcon = new ItemStack(this.getTabIconItem(), 1,
					this.getItemDamage());
		}

		return this.itemIcon;
	}

	@SideOnly(Side.CLIENT)
	public abstract Item getTabIconItem();

	@SideOnly(Side.CLIENT)
	public int getItemDamage() {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public ResourceLocation getBackgroundImageTexture() {
		return this.backgroundImageTexture;
	}

	@SideOnly(Side.CLIENT)
	public boolean drawInForegroundOfTab() {
		return this.drawTitle;
	}

	public SurvivalTabs setNoTitle() {
		this.drawTitle = false;
		return this;
	}

	/**
	 * returns index % 6
	 */
	@SideOnly(Side.CLIENT)
	public int getTabColumn() {
		if (tabIndex > 11) {
			return ((tabIndex - 12) % 10) % 5;
		}
		return this.tabIndex % 6;
	}

	/**
	 * returns tabIndex < 6
	 */
	@SideOnly(Side.CLIENT)
	public boolean isTabInFirstRow() {
		if (tabIndex > 11) {
			return ((tabIndex - 12) % 10) < 5;
		}
		return this.tabIndex < 6;
	}

	public boolean isPlayerNeeded() {
		return this.isDrawPlayerNeeded;
	}

	public int getTabPage() {
		if (tabIndex > 11) {
			return ((tabIndex - 12) / 10) + 1;
		}
		return 0;
	}

	public static int getNextID() {
		return survivalTabArray.length;
	}

	public int getLeftSize() {
		return this.fromLeftSize;
	}

	public int getTheTop() {
		return this.fromTheTop;
	}

	public int getScale() {
		return this.scale;
	}

	public SurvivalTabs addPlayer(int fromLeftSize, int fromTheTop, int scale) {
		this.isDrawPlayerNeeded = true;
		this.fromLeftSize = fromLeftSize;
		this.fromTheTop = fromTheTop;
		this.scale = scale;
		return this;
	}

	@SideOnly(Side.CLIENT)
	public abstract Container getContainer();
}