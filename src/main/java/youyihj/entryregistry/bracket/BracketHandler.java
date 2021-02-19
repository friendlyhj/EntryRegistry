package youyihj.entryregistry.bracket;

import com.blamejared.crafttweaker.api.annotations.BracketResolver;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.item.ItemGroup;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.block.BlockRepresentation;
import youyihj.entryregistry.item.ItemRepresentation;
import youyihj.entryregistry.item.MCItemGroup;
import youyihj.entryregistry.registry.BlockRegistry;
import youyihj.entryregistry.registry.ItemRegistry;

import java.util.Optional;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "BracketHandler")
public class BracketHandler {
    @BracketResolver("itemGroup")
    @ZenCodeType.Method
    public static MCItemGroup getItemGroup(String tokens) {
        for (ItemGroup group : ItemGroup.GROUPS) {
            if (group.tabLabel.equals(tokens)) {
                return new MCItemGroup(group);
            }
        }
        throw new IllegalArgumentException("could not get item group: <itemGroup:" + tokens + ">");
    }

    @BracketResolver("itemRepresentation")
    @ZenCodeType.Method
    public static ItemRepresentation getItemRepresentation(String tokens) {
        return Optional.ofNullable(ItemRegistry.getItem(tokens)).orElseThrow(() -> new IllegalArgumentException("could not get: <itemRepresentation:" + tokens + ">"));
    }

    @BracketResolver("blockRepresentation")
    @ZenCodeType.Method
    public static BlockRepresentation getBlockRepresentation(String tokens) {
        return Optional.ofNullable(BlockRegistry.getBlock(tokens)).orElseThrow(() -> new IllegalArgumentException("could not get: <blockRepresentation:" + tokens + ">"));
    }
}
