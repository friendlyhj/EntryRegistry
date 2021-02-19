package youyihj.entryregistry.registry;

import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.block.BlockContent;
import youyihj.entryregistry.block.BlockRepresentation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author youyihj
 */
public class BlockRegistry {
    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, EntryRegistry.MODID);
    private static final Map<String, BlockRepresentation> BLOCKS = new HashMap<>();

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }

    public static void registerBlock(BlockContent block) {
        REGISTER.register(block.getRepresentation().getBuilder().getName(), () -> block);
        BLOCKS.put(block.getRepresentation().getBuilder().getName(), block.getRepresentation());
        ItemRegistry.registerBlockItem(block);
    }

    public static BlockRepresentation getBlock(String name) {
        return BLOCKS.get(name);
    }
}
