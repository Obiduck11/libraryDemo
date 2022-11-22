package nl.miwgroningen.ch10.jacob.libraryDemo.model;

/**
 * Author: Jacob Visser
 * <p>
 * hier komen gegevens over boeken.
 */

public class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(){
        this("", "");
    }


}
