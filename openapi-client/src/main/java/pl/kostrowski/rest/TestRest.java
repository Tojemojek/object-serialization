package pl.kostrowski.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kostrowski.api.ApiImpl;
import pl.kostrowski.generated.model.Thor;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestRest {

    private final ApiImpl api;

    @GetMapping("/test")
    public Thor test() {
        return api.getThor();
    }
    @GetMapping("/test2")
    public List<Thor> tests() {
        return api.getThors(10);
    }

}
