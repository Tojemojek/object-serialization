package pl.kostrowski.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import pl.kostrowski.generated.api.ThorsApi;
import pl.kostrowski.generated.model.Thor;
import pl.kostrowski.model.ThorFactory;

import java.util.List;

@Controller
public class ThorsApiImpl implements ThorsApi {
    private final ThorFactory thorFactory = new ThorFactory();
    @Override
    public ResponseEntity<List<Thor>> thorsGet() {
        return ResponseEntity.ok(thorFactory.createThor(10));
    }
}
