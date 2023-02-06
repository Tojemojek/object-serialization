package pl.kostrowski.api;

import org.springframework.stereotype.Service;
import pl.kostrowski.generated.ApiClient;
import pl.kostrowski.generated.api.DefaultApi;
import pl.kostrowski.generated.model.Thor;

import java.util.List;

@Service
public class ApiImpl {

    private final DefaultApi defaultApi;

    public ApiImpl(DefaultApi defaultApi) {
        ApiClient apiClient = defaultApi.getApiClient();
        apiClient.setBasePath("http://localhost:8080");
        this.defaultApi = defaultApi;
    }

    public Thor getThor() {
        return defaultApi.thorGet();
    }

    public List<Thor> getThors(Integer thorscount) {
        return defaultApi.thorsGet(thorscount);
    }

}
