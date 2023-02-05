package pl.kostrowski;

import org.junit.jupiter.api.Test;
import pl.kostrowski.generated.model.Thor;
import pl.kostrowski.model.ThorService;
import pl.kostrowski.service.ObjectMapperConfiguration;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class JsonMapperTest {
    @Test
    void fullSerializationTest() throws IOException {
        ObjectMapperConfiguration openApiObjectMapper = new ObjectMapperConfiguration();
        ThorService thorService = new ThorService(openApiObjectMapper.objectMapper());
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
        ObjectMapperConfiguration openApiObjectMapper = new ObjectMapperConfiguration();
        ThorService thorService = new ThorService(openApiObjectMapper.objectMapper());
        List<Thor> thors = thorService.createThorList(10000);
        thorService.serializeToDrive(thors);
    }

    @Test
    void deSerializationTest() {
        ObjectMapperConfiguration openApiObjectMapper = new ObjectMapperConfiguration();
        ThorService thorService = new ThorService(openApiObjectMapper.objectMapper());
        List<Thor> deserialize = thorService.deserialize();
        System.out.println(deserialize.size());
    }
}