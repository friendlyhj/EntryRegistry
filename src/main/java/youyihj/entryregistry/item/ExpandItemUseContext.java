package youyihj.entryregistry.item;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.impl.item.MCItemStackMutable;
import com.blamejared.crafttweaker.impl.util.MCDirection;
import com.blamejared.crafttweaker_annotations.annotations.NativeTypeRegistration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;

/**
 * @author youyihj
 */
@ZenRegister
@NativeTypeRegistration(value = ItemUseContext.class, zenCodeName = EntryRegistry.ZC_HOME + "MCItemUseContext")
public class ExpandItemUseContext {
    @ZenCodeType.Getter("player")
    @ZenCodeType.Nullable
    public static PlayerEntity getPlayer(ItemUseContext internal) {
        return internal.getPlayer();
    }

    @ZenCodeType.Getter("hand")
    public static EquipmentSlotType getHand(ItemUseContext internal) {
        switch (internal.getHand()) {
            case MAIN_HAND:
                return EquipmentSlotType.MAINHAND;
            case OFF_HAND:
                return EquipmentSlotType.OFFHAND;
            default:
                throw new IllegalStateException("The player has the third hand?!");
        }
    }

    @ZenCodeType.Getter("pos")
    @ZenCodeType.Nullable
    public static BlockPos getPos(ItemUseContext internal) {
        return internal.getPos();
    }

    @ZenCodeType.Getter("item")
    public static MCItemStackMutable getItem(ItemUseContext internal) {
        return new MCItemStackMutable(internal.getItem());
    }

    @ZenCodeType.Getter("world")
    public static World getWorld(ItemUseContext internal) {
        return internal.getWorld();
    }

    @ZenCodeType.Getter("face")
    public static MCDirection getFace(ItemUseContext internal) {
        return MCDirection.get(internal.getFace());
    }

    @ZenCodeType.Getter("secondaryUse")
    public static boolean hasSecondaryUse(ItemUseContext internal) {
        return internal.hasSecondaryUseForPlayer();
    }
}
