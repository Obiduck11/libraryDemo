package nl.miwgroningen.ch10.jacob.libraryDemo.controller;

import nl.miwgroningen.ch10.jacob.libraryDemo.database.BookDAO;
import nl.miwgroningen.ch10.jacob.libraryDemo.database.DBaccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Jacob Visser
 * <p>
 * geeft toegang tot alle paginas over boeken.
 */

@Controller
public class BookController {

    @GetMapping("/books")
    protected String showBookOverview(Model model){
        DBaccess dBaccess = new DBaccess("libraryDemo",
                "userLibrary", "userLibraryPW");
        dBaccess.openConnection();
        BookDAO bookDAO = new BookDAO(dBaccess);
        model.addAttribute("books", bookDAO.getAllBooks());
        dBaccess.closeConnection();

        return "bookOverview";

    }


}
