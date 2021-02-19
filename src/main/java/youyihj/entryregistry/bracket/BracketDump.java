package youyihj.entryregistry.bracket;

import com.blamejared.crafttweaker.api.annotations.BracketDumper;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import net.minecraft.item.ItemGroup;
import org.openzen.zencode.java.ZenCodeType;
import youyihj.entryregistry.EntryRegistry;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author youyihj
 */
@ZenRegister
@ZenCodeType.Name(EntryRegistry.ZC_HOME + "BracketDumper")
public class BracketDump {
    @BracketDumper("itemGroup")
    public static Collection<String> getItemGroups() {
        return Arrays.stream(ItemGroup.GROUPS)
                .map(group -> "<itemGroup:" + group.tabLabel + ">")
                .collect(Collectors.toList());
    }
}
