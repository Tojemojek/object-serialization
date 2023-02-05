package pl.kostrowski;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import pl.kostrowski.avro.Thor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThorService {
    private final ThorFactory thorFactory = new ThorFactory();
    private final String tmpPath = "/tmp/avro/";

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

            DatumWriter<Thor> userDatumWriter = new SpecificDatumWriter<>(Thor.class);
            try (DataFileWriter<Thor> dataFileWriter = new DataFileWriter<>(userDatumWriter);) {
                dataFileWriter.create(thor.getSchema(), file);
                dataFileWriter.append(thor);
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
            DatumReader<Thor> userDatumReader = new SpecificDatumReader<>(Thor.class);
            try (DataFileReader<Thor> dataFileReader = new DataFileReader<>(f, userDatumReader)) {
                while (dataFileReader.hasNext()) {
                    ret.add(dataFileReader.next());
                    i++;
                }
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
