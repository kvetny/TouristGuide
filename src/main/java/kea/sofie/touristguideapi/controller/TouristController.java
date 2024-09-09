// Controller-pakken indeholder klasser, der håndterer HTTP-forespørgelser fra klienter (en browser)
package kea.sofie.touristguideapi.controller;

// Importerer modellen TouristAttraction, så den kan bruges i controlleren
import kea.sofie.touristguideapi.model.TouristAttraction;
// Importerer serviceklassen, som indeholder forretningslogikken
import kea.sofie.touristguideapi.service.TouristService;
// Importerer HTTP-statuskoder
import org.springframework.http.HttpStatus;
// Importerer ResponseEntity, som bruges til at sende HTTP-svar
import org.springframework.http.ResponseEntity;
// Importerer Controller-annotationen for at markere klassen som en controller
import org.springframework.stereotype.Controller;
// Importerer GetMapping-annotationen, der bruges til at definere HTTP GET-endpoints
import org.springframework.web.bind.annotation.*;
// Importerer PathVariable-annotationen, der bruges til at hente variabler fra URL'en
// Importerer RequestMapping-annotationen for at definere basis-URL'en for controlleren
import java.util.List;


// Betyder at klassen er en controller, der håndterer HTTP-forespørgelser
@Controller
@RequestMapping("attractions") // definerer basis-URL'en for alle endpoints i denne controller
public class TouristController {

    private final TouristService touristService;

    // Konstruktør
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }


    // Definerer et HTTP GET-endpoint, der returnerer alle turistattraktioner
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getTouristAttraction() {
        List touristAttractions = touristService.getAttractions(); // Kalder service-metoden for at hente alle attraktioner
        return new ResponseEntity<List<TouristAttraction>>(touristAttractions, HttpStatus.OK);// Returnerer attraktionerne som et HTTP-svar med statuskoden 200 OK
    }

    // Definerer et HTTP GET-endpoint, der returnerer en specifik turistattraktion baseret på navn
    @GetMapping("/{name}") // PathVariable '{name}' bliver brugt til at hente variabel fra URL'en
    public ResponseEntity<TouristAttraction> getTouristAttraction(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttractionByName(name); // Henter attraktionen ved at kalde service-metoden med det ønskede navn
        return new ResponseEntity<TouristAttraction>(attraction, HttpStatus.OK); // Returnerer attraktionen som et HTTP-svar med statuskoden 200 OK
    }


    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction newAttraction = touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(newAttraction, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        TouristAttraction updatedAttraction = touristService.updateAttraction(touristAttraction);
        if (updatedAttraction != null) {
            return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable String name) {
        boolean deleted = touristService.deleteAttraction(name);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Hvis sletningen er succesfuld = kode 204
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Hvis attraktionen ikke blev fundet = kode 404
        }
    }

}




