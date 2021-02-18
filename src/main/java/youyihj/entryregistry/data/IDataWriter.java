package youyihj.entryregistry.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.util.IItemProvider;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.block.BlockItemContent;
import youyihj.entryregistry.block.BlockRepresentation;
import youyihj.entryregistry.item.ItemRepresentation;

import java.util.List;

/**
 * @author youyihj
 */
public interface IDataWriter<T extends IDataGeneratorTarget> {

    String RESOURCES_ROOT = "global_resource_packs/entryregistryresources/assets/" + EntryRegistry.MODID + "/";
    String DATA_ROOT = "global_data_packs/entryregistry/data/" + EntryRegistry.MODID + "/";

    void getWritePaths(List<String> paths, T instance);

    JsonElement write(String path, T instance);

    Class<T> writeObjClass();

    enum Item implements IDataWriter<ItemRepresentation> {
        INSTANCE;

        @Override
        public JsonElement write(String path, ItemRepresentation instance) {
            JsonObject json = new JsonObject();
            json.addProperty("parent", "minecraft:item/generated");
            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", EntryRegistry.MODID + ":item/" + instance.getBuilder().getName());
            json.add("textures", textures);
            return json;
        }

        @Override
        public void getWritePaths(List<String> paths, ItemRepresentation instance) {
            paths.add(RESOURCES_ROOT + "models/item/" + instance.getBuilder().getName() + ".json");
        }

        @Override
        public Class<ItemRepresentation> writeObjClass() {
            return ItemRepresentation.class;
        }
    }

    enum Meta implements IDataWriter<IDataWriter.Meta>, IDataGeneratorTarget {
        INSTANCE;

        @Override
        public void getWritePaths(List<String> paths, Meta instance) {
            paths.add("global_data_packs/entryregistry/pack.mcmeta");
            paths.add("global_resource_packs/entryregistryresources/pack.mcmeta");
        }

        @Override
        public JsonElement write(String path, Meta instance) {
            JsonObject json = new JsonObject();
            JsonObject pack = new JsonObject();
            pack.addProperty("pack_format", 6);
            pack.addProperty("description", "entry registry");
            json.add("pack", pack);
            return json;
        }

        @Override
        public Class<Meta> writeObjClass() {
            return Meta.class;
        }
    }

    enum Block implements IDataWriter<BlockRepresentation> {
        INSTANCE;

        private String getModelPath(BlockRepresentation instance) {
            return RESOURCES_ROOT + "models/block/" + instance.getBuilder().getName() + ".json";
        }

        private String getBlockStatePath(BlockRepresentation instance) {
            return RESOURCES_ROOT + "blockstates/" + instance.getBuilder().getName() + ".json";
        }

        private String getLootPath(BlockRepresentation instance) {
            return DATA_ROOT + "loot_tables/blocks/" + instance.getBuilder().getName() + ".json";
        }

        private LootTable.Builder genRegularLootTable(IItemProvider provider) {
            LootEntry.Builder<?> entry = ItemLootEntry.builder(provider);
            LootPool.Builder pool = LootPool.builder().name("main").rolls(ConstantRange.of(1)).addEntry(entry)
                    .acceptCondition(SurvivesExplosion.builder());
            return LootTable.builder().addLootPool(pool);
        }

        @Override
        public void getWritePaths(List<String> paths, BlockRepresentation instance) {
            paths.add(getModelPath(instance));
            paths.add(getBlockStatePath(instance));
            paths.add(getLootPath(instance));
        }

        @Override
        public JsonElement write(String path, BlockRepresentation instance) {
            JsonObject json = new JsonObject();
            if (path.equals(getModelPath(instance))) {
                json.addProperty("parent", "minecraft:block/cube_all");
                JsonObject textures = new JsonObject();
                textures.addProperty("all", EntryRegistry.MODID + ":block/" + instance.getBuilder().getName());
                json.add("textures", textures);
                return json;
            }
            if (path.equals(getBlockStatePath(instance))) {
                JsonObject variants = new JsonObject();
                JsonObject empty = new JsonObject();
                empty.addProperty("model", EntryRegistry.MODID + ":block/" + instance.getBuilder().getName());
                variants.add("", empty);
                json.add("variants", variants);
                return json;
            }
            if (path.equals(getLootPath(instance))) {
                return LootTableManager.toJson(genRegularLootTable(instance).setParameterSet(LootParameterSets.BLOCK).build());
            }
            return null;
        }

        @Override
        public Class<BlockRepresentation> writeObjClass() {
            return BlockRepresentation.class;
        }
    }

    enum BlockItem implements IDataWriter<BlockItemContent> {
        INSTANCE;

        @Override
        public void getWritePaths(List<String> paths, BlockItemContent instance) {
            paths.add(RESOURCES_ROOT + "models/item/" + instance.blockContent.getRepresentation().getBuilder().getName() + ".json");
        }

        @Override
        public JsonElement write(String path, BlockItemContent instance) {
            JsonObject json = new JsonObject();
            json.addProperty("parent", EntryRegistry.MODID + ":block/" + instance.blockContent.getRepresentation().getBuilder().getName());
            return json;
        }

        @Override
        public Class<BlockItemContent> writeObjClass() {
            return BlockItemContent.class;
        }
    }
}
