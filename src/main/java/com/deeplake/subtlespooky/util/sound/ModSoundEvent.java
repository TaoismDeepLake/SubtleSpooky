package com.deeplake.subtlespooky.util.sound;

import com.deeplake.subtlespooky.util.ModSoundHandler;
import com.deeplake.subtlespooky.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ModSoundEvent extends SoundEvent {
    public ModSoundEvent(String path) {
        super(new ResourceLocation(Reference.MOD_ID, path));
        ModSoundHandler.SOUNDS.add(this);
        setRegistryName(path);
    }
}
