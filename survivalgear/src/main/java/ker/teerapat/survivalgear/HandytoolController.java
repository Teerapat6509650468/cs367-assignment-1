package ker.teerapat.survivalgear;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class HandytoolController {
    private final SurvivalgearRepository repository;

    HandytoolController(SurvivalgearRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/survivalgears")    
    List<Survivalgear> findAll() {
        return repository.findAll();
    }

    @GetMapping("/survivalgears/{id}")
    Survivalgear findOne(@PathVariable Long id) {
        Optional<Survivalgear> survivalgear =  repository.findById(id);
        if (survivalgear.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no survival gear by given id");
        }
        return survivalgear.get();
    }
    
    @PostMapping("/survivalgears")
    Survivalgear newSurvivalgear(@RequestBody Survivalgear survivalgear) {        
        return repository.save(survivalgear);
    }
    
    @PutMapping("/survivalgears/{id}")
    Survivalgear saveSurvivalgear(@RequestBody Survivalgear newSurvivalgear, @PathVariable Long id) {
        return repository.findById(id).map(survivalgear -> {
            survivalgear.setBorrowed(newSurvivalgear.getBorrowed());
            survivalgear.setBorrowerName(newSurvivalgear.getBorrowerName());
            survivalgear.setLocationName(newSurvivalgear.getLocationName());
            survivalgear.setOwnerName(newSurvivalgear.getOwnerName());
            survivalgear.setSurvivalgearDetail(newSurvivalgear.getSurvivalgearDetail());
            return repository.save(survivalgear);
        }).orElseGet(() -> {
            return repository.save(newSurvivalgear);
        });
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/survivalgears/{id}")
    void deleteSurvivalgear(@PathVariable Long id) {
        repository.deleteById(id);
    }

}