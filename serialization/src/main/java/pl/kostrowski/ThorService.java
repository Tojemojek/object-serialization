package pl.kostrowski;

import pl.kostrowski.serialization.Thor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThorService {
    private final ThorFactory thorFactory = new ThorFactory();
    private final String tmpPath = "/tmp/serialization/";

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
            File file = new File(tmpPath + "thor" + i + ".ser");
            try (FileOutputStream fileOutputStream = new FileOutputStream(file); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(thor);
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
                .filter(f->f.getName().endsWith(".ser"))
                .toList();
        List<Thor> ret = new ArrayList<>();
        int i = 0;
        for (File f : s) {
            try (FileInputStream fileInputStream = new FileInputStream(f);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                ret.add((Thor) objectInputStream.readObject());
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
