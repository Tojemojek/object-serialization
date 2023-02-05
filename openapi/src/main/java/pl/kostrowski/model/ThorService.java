package pl.kostrowski.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.kostrowski.generated.model.Thor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ThorService {
    private final ThorFactory thorFactory = new ThorFactory();
    private final ObjectMapper objectMapper;

    public ThorService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private final String tmpPath = "/tmp/json/";

    public List<Thor> createThorList(int numberOfThors) {
        List<Thor> ret = new ArrayList<>();
        for (int i = 0; i < numberOfThors; i++) {
            ret.add(thorFactory.createThor());
        }
        return ret;
    }

    public void serializeToDrive(List<Thor> thors) throws IOException {
        int i = 0;
        File folder = new File(tmpPath);
        Files.createDirectories(folder.toPath());
        for (Thor thor : thors) {
            File file = new File(tmpPath + "thor" + i + ".json");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file);) {
                objectMapper.writeValue(fileOutputStream, thor);
                i++;
                if (i % 100 == 0) {
                    System.out.println("Serialized " + i + " thors");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public List<Thor> deserialize() {
        File file = new File(tmpPath);
        List<File> s = Arrays.stream(file.listFiles())
                .filter(f->f.getName().endsWith(".json"))
                .toList();
        List<Thor> ret = new ArrayList<>();
        int i = 0;
        for (File f : s) {
            try (FileInputStream fileInputStream = new FileInputStream(f)) {
                ret.add(objectMapper.readValue(fileInputStream, Thor.class));
                i++;
                if (i % 100 == 0) {
                    System.out.println("Deserialized " + i + " thors");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

}
