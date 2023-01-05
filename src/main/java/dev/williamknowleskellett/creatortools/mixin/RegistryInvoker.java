package dev.williamknowleskellett.creatortools.mixin;

import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import com.mojang.serialization.Lifecycle;

@Mixin(Registry.class)
public interface RegistryInvoker {

	@Invoker("create")
	public static <T, R extends MutableRegistry<T>> R invokeCreate(RegistryKey<? extends Registry<T>> key, R registry, Supplier<T> defaultEntry, Lifecycle lifecycle) {
		throw new AssertionError();
	}
}
