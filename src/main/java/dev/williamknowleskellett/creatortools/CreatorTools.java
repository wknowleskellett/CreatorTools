package dev.williamknowleskellett.creatortools;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreatorTools implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("creatortools");
	public static final Item ACORN = new AcornItem(new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier("creatortools", "acorn"), ACORN);
		// RegistryInvoker.invokeCreate(null, null, null, null);
	}
}