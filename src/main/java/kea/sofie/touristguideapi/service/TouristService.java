// Service-pakken indeholder klasser, der håndterer forretningslogik og kommunikation mellem controller og repository
package kea.sofie.touristguideapi.service;

// Impoterer modellen TouristAttraction
import kea.sofie.touristguideapi.model.TouristAttraction;
// Im
import kea.sofie.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Betyder at klassen er en service-komponent i Spring
public class TouristService {

   private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    // Metode til at hente alle turistattraktioner ved at kalde repository-metoden
    public List<TouristAttraction> getAttractions() {
        return touristRepository.getAttractions();
    }

    // Metode til at hente en attraktion baseret på navn ved at kalde repository-metoden
    public TouristAttraction getAttractionByName(String name) {
        return touristRepository.getOneAttraction(name); // Returnerer attraktionen med det ønskede navn fra repository
    }

    // Metode til at tilføje en ny attraktion
    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addAttraction(touristAttraction);
    }

    // Metode til at opdatere beskrivelsen til en specifik attraktion
    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        return touristRepository.updateAttraction(touristAttraction);
    }

    // Metode til at slette en attraktion
    public boolean deleteAttraction(String name) {
        return touristRepository.deleteAttraction(name);
    }


}


