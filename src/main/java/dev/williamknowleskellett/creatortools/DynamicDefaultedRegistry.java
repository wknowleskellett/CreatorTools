package dev.williamknowleskellett.creatortools;

import java.util.Optional;
import java.util.Random;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.Lifecycle;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

public class DynamicDefaultedRegistry<T> extends DefaultedRegistry<T> {

    private final Identifier defaultId;
    private final int defaultRawId;
    private T defaultEntry;

    public DynamicDefaultedRegistry(String defaultId, RegistryKey<? extends Registry<T>> key, Lifecycle lifecycle) {
        super(defaultId, key, lifecycle);
        this.defaultId = super.getDefaultId();
        this.defaultEntry = super.get(this.defaultId);
        this.defaultRawId = super.getRawId(this.defaultEntry);
    }

    @Override
    public <V extends T> V set(int rawId, RegistryKey<T> key, V entry, Lifecycle lifecycle) {
        if (this.defaultId.equals(key.getValue())) {
            this.defaultEntry = entry;
        }
        if ("creatortools:acorn".equals(key.getValue().toString())) {
            CreatorTools.LOGGER.info("ACORN received in DynamicDefaultedRegistry");
        }
        return super.set(rawId, key, entry, lifecycle);
    }

    @Override
    public int getRawId(@Nullable T entry) {
        int i = super.getRawId(entry);
        if (i == this.defaultRawId) {
            // TODO defer to my custom class
        }
        return i;
    }

    @Override
    @NotNull
    public Identifier getId(T entry) {
        Identifier identifier = super.getId(entry);
        if (identifier.equals(this.defaultId)) {
            // TODO defer to my custom class
        }
        return identifier == null ? this.defaultId : identifier;
    }

    @Override
    @NotNull
    public T get(@Nullable Identifier id) {
        T entry = super.get(id);
        if (entry == this.defaultEntry) {
            // TODO defer to my custom class
        }
        return entry;
        // Object object = super.get(id);
        // return object == null ? this.defaultValue : object;
    }

    @Override
    public Optional<T> getOrEmpty(@Nullable Identifier id) {
        // return Optional.ofNullable(super.get(id));
        Optional<T> maybeT = super.getOrEmpty(id);
        if (maybeT.isEmpty()) {
            // TODO defer to my custom class
        }
        return maybeT;
    }

    @Override
    @NotNull
    public T get(int index) {
        T entry = super.get(index);
        if (entry == this.defaultEntry) {
            // TODO defer to my custom class
        }
        return entry;
    }

    @Override
    @NotNull
    public T getRandom(Random random) {
        T entry = super.getRandom(random);
        if (entry == this.defaultEntry) {
            // TODO defer to my custom class
        }
        return entry;
    }

    @Override
    public Identifier getDefaultId() {
        return this.defaultId;
    }
    
}
