package nl.miwgroningen.ch10.jacob.libraryDemo.model;

/**
 * Author: Jacob Visser
 * <p>
 * Dit is wat het programma doet.
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
