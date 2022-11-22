package nl.miwgroningen.ch10.jacob.libraryDemo.database;

import nl.miwgroningen.ch10.jacob.libraryDemo.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author: Jacob Visser
 * <p>
 * Dit is wat het programma doet.
 */

public class BookDAO extends AbstractDAO {

    public BookDAO(DBaccess dBaccess){
        super(dBaccess);
    }

    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT title, author FROM book;";

        try {
            setupPreparedStatement(sql);
            ResultSet resultset = executeSelectStatement();
            while(resultset.next()){
                String title = resultset.getString(1);
                String author = resultset.getString(2);
                books.add(new Book(title, author));
            }
        } catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
            }

        return books;
    }

}
