package youyihj.entryregistry.data;

import com.google.gson.JsonObject;
import youyihj.entryregistry.EntryRegistry;
import youyihj.entryregistry.item.ItemRepresentation;

import java.util.List;

/**
 * @author youyihj
 */
public interface IDataWriter<T> {

    String RESOURCES_ROOT = "global_resource_packs/entryregistryresources/assets/" + EntryRegistry.MODID;
    String DATA_ROOT = "global_data_packs/entryregistry/data/" + EntryRegistry.MODID;

    void getWritePaths(List<String> paths, T instance);

    void write(String path, JsonObject json, T instance);

    Class<T> writeObjClass();

    enum Item implements IDataWriter<ItemRepresentation> {
        INSTANCE;

        @Override
        public void write(String path, JsonObject json, ItemRepresentation instance) {
            json.addProperty("parent", "minecraft:item/generated");
            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", EntryRegistry.MODID + ":item/" + instance.getBuilder().getName());
            json.add("textures", textures);
        }

        @Override
        public void getWritePaths(List<String> paths, ItemRepresentation instance) {
            paths.add(RESOURCES_ROOT + "/models/item/" + instance.getBuilder().getName() + ".json");
        }

        @Override
        public Class<ItemRepresentation> writeObjClass() {
            return ItemRepresentation.class;
        }
    }

    enum Meta implements IDataWriter<IDataWriter.Meta> {
        INSTANCE;

        @Override
        public void getWritePaths(List<String> paths, Meta instance) {
            paths.add("global_data_packs/entryregistry/pack.mcmeta");
            paths.add("global_resource_packs/entryregistryresources/pack.mcmeta");
        }

        @Override
        public void write(String path, JsonObject json, Meta instance) {
            JsonObject pack = new JsonObject();
            pack.addProperty("pack_format", 6);
            pack.addProperty("description", "entry registry");
            json.add("pack", pack);
        }

        @Override
        public Class<Meta> writeObjClass() {
            return Meta.class;
        }
    }
}
