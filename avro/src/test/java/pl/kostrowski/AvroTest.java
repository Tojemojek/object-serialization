package pl.kostrowski;

import org.junit.jupiter.api.Test;
import pl.kostrowski.avro.Thor;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class AvroTest {
    @Test
    void fullSerializationTest() throws IOException {
        ThorService thorService = new ThorService();
        List<Thor> thors = thorService.createThorList(10000);
        LocalDateTime start = LocalDateTime.now();
        thorService.serializeToDrive(thors);
        List<Thor> deserialize = thorService.deserialize();
        LocalDateTime end = LocalDateTime.now();

        Duration between = Duration.between(start, end);
        System.out.println("Time: " + between.toMillis());

        assertThat(deserialize).hasSameElementsAs(thors);
    }

    @Test
    void serializationTest() throws IOException {
        ThorService thorService = new ThorService();
        List<Thor> thors = thorService.createThorList(10000);
        thorService.serializeToDrive(thors);
    }

    @Test
    void deSerializationTest() {
        ThorService thorService = new ThorService();
        List<Thor> deserialize = thorService.deserialize();
        System.out.println(deserialize.size());
    }
}