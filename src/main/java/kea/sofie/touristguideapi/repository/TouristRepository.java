// Repository-pakken indeholder klasser, der håndterer dataadgang og lagring
package kea.sofie.touristguideapi.repository;

// Importerer modellen så den kan bruges i dennne klasse
import kea.sofie.touristguideapi.model.TouristAttraction;
// Importerer Repository-annotationen for at markere klassen som et datahåndteringslag
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Betyder at denne klasse fungerer som et repository i Spring boot applikationen (Dataadgang og lagring)
@Repository
public class TouristRepository {

    // Liste til opbevaring af turistattraktioner
    private List<TouristAttraction>TouristAttractions = new ArrayList<>(List.of(
            //Opretter to attraktioner og tilføjer dem til listen
        new TouristAttraction("tivoli", "Et af verdens aeldste forlystelsesparker"),
        new TouristAttraction("denlillehavfrue", "En meget gammel skulptur"),
        new TouristAttraction("zoo", "Mere end 4000 fascinerende dyr"),
        new TouristAttraction("denblåplanet", "Oplev verden under overfladen"),
        new TouristAttraction("amalienborg", "Se hvor de kongelige bor"),
        new TouristAttraction("nationalmuseet", "Se hele Danmarks historie"),
        new TouristAttraction("rundetaarn", "Se hvad Christian IV har bygget")));


    // Metode der returnerer hele listen af turistattraktioner
    public List<TouristAttraction> getAttractions() {
        return TouristAttractions;
    }

    // Metode til at hente en specifik attraktion baseret på navnet
    public TouristAttraction getOneAttraction(String name){
        // Looper igennem listen for at finde en attraktion med netop det navn
        for (TouristAttraction touristAttraction : TouristAttractions) {
            if (touristAttraction.getName().equals(name)) { // Tjekker om attraktionens navn matcher det søgte
                return touristAttraction; // Returnerer attraktionen hvis den findes
            }
        }
        return null; // Returnerer ingenting hvis den ikke findes
    }


    // Metode til at tilføje en ny attraktion
    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        TouristAttractions.add(touristAttraction);
        return touristAttraction;
    }

    // Metode til at opdatere en attraktions beskrivelse
    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction touristAttraction1 : TouristAttractions) {
            if (touristAttraction1.getName().equals(touristAttraction.getName())) {
                touristAttraction1.setDescription(touristAttraction.getDescription());
                return touristAttraction1;
            }
        }
        return null; // Returnerer null hvis attraktionen ikke findes
    }

    // Metode til at slette en attraktion
    public boolean deleteAttraction(String name) {
        Iterator<TouristAttraction> iterator = TouristAttractions.iterator();
        while (iterator.hasNext()) {
            TouristAttraction touristAttraction = iterator.next();
            if (touristAttraction.getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
