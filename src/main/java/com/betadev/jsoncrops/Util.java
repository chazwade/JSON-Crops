package com.betadev.jsoncrops;

import cpw.mods.fml.common.registry.GameData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Util {
	public static Object getInputItem(String inputItem) {
		Item item = getItem(inputItem);
		// If item is null, we'll assume it's an oreDict
		if(item == null) {
			return inputItem;
		}
		return item;
	}

	public static ItemStack getOutputItem(String outputItem) {
		int amount = 1;
		if(outputItem.contains("#")) {
			String[] outputSplit = outputItem.split("#");
			outputItem = outputSplit[0];
			amount = Integer.parseInt(outputSplit[1]);
		}
		int meta = 0;
		if(outputItem.contains(":")) {
			String[] outputSplit = outputItem.split(":");
			outputItem = outputSplit[0];
			meta = Integer.parseInt(outputSplit[1]);
		}
		return new ItemStack(getItem(outputItem), amount, meta);
	}

	private static Item getItem(String itemName) {
		Item item = GameData.getItemRegistry().getObject(itemName);
		if(item == null) {
			return item;
		}
		return null;
	}
}