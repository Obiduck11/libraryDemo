package nl.miwgroningen.ch10.jacob.libraryDemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Author: Jacob Visser
 * <p>
 * Dit is wat het programma doet.
 */
@Entity @Getter @Setter
public class Copy {
    @Id
    @GeneratedValue
    private Long copyId;

    @ManyToOne
    private Book book;

    boolean available = true;


}
