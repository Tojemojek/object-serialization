package pl.kostrowski.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import pl.kostrowski.generated.api.ThorApi;
import pl.kostrowski.generated.model.Thor;
import pl.kostrowski.model.ThorFactory;

@Controller
public class ThorApiImpl implements ThorApi {
    private final ThorFactory thorFactory = new ThorFactory();
    @Override
    public ResponseEntity<Thor> thorGet() {
        return ResponseEntity.ok(thorFactory.createThor());
    }
}
