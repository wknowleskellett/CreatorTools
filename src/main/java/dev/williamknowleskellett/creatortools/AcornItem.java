package dev.williamknowleskellett.creatortools;

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
    playerEntity.playSound(SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, 1.0F, 1.0F);
    return TypedActionResult.success(playerEntity.getStackInHand(hand));
  }

}
