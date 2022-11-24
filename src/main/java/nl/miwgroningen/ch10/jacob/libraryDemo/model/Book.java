package nl.miwgroningen.ch10.jacob.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Jacob Visser
 * <p>
 * hier komen gegevens over boeken.
 */
@Entity @Getter @Setter
public class Book {
    @Id
    @GeneratedValue
    private Long bookId;

    private String title;
    private String author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<Copy> copies;

    public int getNumberOfAvailableCopies() {
        int count = 0;

        for (Copy copy : copies) {
            if (copy.available) {
                count++;
            }
        }

        return count;
    }

}
