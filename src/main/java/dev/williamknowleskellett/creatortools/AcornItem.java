package dev.williamknowleskellett.creatortools;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AcornItem extends Item {

  public AcornItem(Settings settings) {
    super(settings);
    // TODO Auto-generated constructor stub
  }

  @Override
  public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
    // StatusEffectInstance statusEffectInstance;
    playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1, false, true),
        playerEntity);
    playerEntity.playSound(SoundEvents.BLOCK_PISTON_EXTEND, 1.0F, 1.0F);
    return TypedActionResult.success(playerEntity.getStackInHand(hand));
  }

}
