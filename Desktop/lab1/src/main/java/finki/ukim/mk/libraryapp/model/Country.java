package finki.ukim.mk.libraryapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String continent;

    public Country() {}

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
