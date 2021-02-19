package youyihj.entryregistry.item;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.impl.brackets.BracketHandlers;
import com.blamejared.crafttweaker_annotations.annotations.ZenWrapper;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "MCItemGroup")
@ZenWrapper(wrappedClass = "net.minecraft.item.ItemGroup")
public class MCItemGroup {
    private final ItemGroup internal;

    public MCItemGroup(ItemGroup internal) {
        this.internal = internal;
    }

    @ZenCodeType.Constructor
    public MCItemGroup(String label, ResourceLocation itemLocation) {
        this.internal = new ItemGroup(label) {
            @Override
            @OnlyIn(Dist.CLIENT)
            public ItemStack createIcon() {
                return BracketHandlers.getItem(itemLocation.toString()).getInternal();
            }
        };
    }

    public ItemGroup getInternal() {
        return internal;
    }
}
