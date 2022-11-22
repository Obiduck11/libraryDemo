package nl.miwgroningen.ch10.jacob.libraryDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: Jacob Visser
 * <p>
 * geeft toegang tot alle paginas over boeken.
 */

@Controller
public class BookController {

    @GetMapping("/books")
    protected String showBookOverview(){
        return "bookOverView";
    }


}
