package youyihj.entryregistry.function;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.item.ItemUseContext;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;

/**
 * @author youyihj
 */
@FunctionalInterface
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "functions.IItemUse")
public interface IItemUse {
    String apply(ItemUseContext context);
}
