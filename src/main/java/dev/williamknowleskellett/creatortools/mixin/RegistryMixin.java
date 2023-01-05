package dev.williamknowleskellett.creatortools.mixin;

import dev.williamknowleskellett.creatortools.CreatorTools;
import dev.williamknowleskellett.creatortools.DynamicDefaultedRegistry;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.mojang.serialization.Lifecycle;

import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

@Mixin(Registry.class)
public class RegistryMixin {
	@Inject(
		at = @At("HEAD"),
		method = "net/minecraft/util/registry/Registry.create(Lnet/minecraft/util/registry/RegistryKey;Ljava/lang/String;Ljava/util/function/Supplier;)Lnet/minecraft/util/registry/DefaultedRegistry;",
		locals = LocalCapture.CAPTURE_FAILHARD,
		cancellable = true
		)
	private static <T> void create(
		RegistryKey<? extends Registry<T>> key,
		String defaultId,
		Supplier<T> defaultEntry,
		CallbackInfoReturnable<DefaultedRegistry<T>> info
	) {
		if (key.toString().equals(Registry.ITEM_KEY.toString())) {
			Lifecycle lifecycle = Lifecycle.experimental();
			DefaultedRegistry<T> retVal = (DefaultedRegistry<T>) RegistryInvoker.invokeCreate(key, new DynamicDefaultedRegistry<T>(defaultId, key, lifecycle), defaultEntry, lifecycle);
			info.setReturnValue(retVal);
		}
	}
}

// public static final DefaultedRegistry<Item> ITEM = Registry.create(ITEM_KEY, "air", () -> Items.AIR);

// private static <T> DefaultedRegistry<T> create(RegistryKey<? extends Registry<T>> key, String defaultId, Supplier<T> defaultEntry) {
// 	return Registry.create(key, defaultId, Lifecycle.experimental(), defaultEntry);
// }

// private static <T> DefaultedRegistry<T> create(RegistryKey<? extends Registry<T>> key, String defaultId, Lifecycle lifecycle, Supplier<T> defaultEntry) {
// 	return Registry.create(key, new DefaultedRegistry(defaultId, key, lifecycle), defaultEntry, lifecycle);
// }
