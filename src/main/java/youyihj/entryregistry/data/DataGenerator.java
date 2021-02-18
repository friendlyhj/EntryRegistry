package youyihj.entryregistry.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author youyihj
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class DataGenerator {
    public static final List<IDataWriter> WRITERS = new ArrayList<>();
    private static final List<IDataGeneratorTarget> TO_WRITE_OBJECTS = new ArrayList<>();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final List<String> tempOutPaths = new ArrayList<>();

    public static void addToGenerateDataObject(IDataGeneratorTarget target) {
        TO_WRITE_OBJECTS.add(target);
    }

    public static void addWriter(IDataWriter<?> writer) {
        WRITERS.add(writer);
    }

    public static void generate() throws IOException {
        for (IDataGeneratorTarget toWriteObject : TO_WRITE_OBJECTS) {
            for (IDataWriter writer : WRITERS) {
                if (toWriteObject.getClass().isAssignableFrom(writer.writeObjClass())) {
                    writer.getWritePaths(tempOutPaths, toWriteObject);
                    for (String tempOutPath : tempOutPaths) {
                        File file = new File(tempOutPath);
                        if (!file.exists()) {
                            String s = GSON.toJson(writer.write(tempOutPath, toWriteObject));
                            FileUtils.writeStringToFile(new File(tempOutPath), s, StandardCharsets.UTF_8);
                        }
                    }
                    tempOutPaths.clear();
                }
            }
        }
    }

}
