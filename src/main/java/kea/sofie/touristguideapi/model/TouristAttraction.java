// Model-pakken indeholder klasser, der repræsenterer data
package kea.sofie.touristguideapi.model;

public class TouristAttraction {

    // Navn og beskrivelse af turistattraktionen
    private String name;
    private String description;



    // Konstruktør som bruges til at oprette en ny TouristAttraction-objekt
    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }


    // Getter-metode til at få navnet på attraktionen
    public String getName() {
        return name;
    }

    // Getter-metode til at få beskrivelsen af attraktionen
    public String getDescription() {
        return description;
    }

    // Setter-metode til at ændre navnet på attraktionen
    public void setName(String name) {
        this.name = name;
    }

    // Setter-metode til at ændre beskrivelsen af attraktionen
    public void setDescription(String description) {
        this.description = description;
    }
}
