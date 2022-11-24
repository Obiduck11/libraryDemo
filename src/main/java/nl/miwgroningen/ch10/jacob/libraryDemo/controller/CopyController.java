package nl.miwgroningen.ch10.jacob.libraryDemo.controller;

import nl.miwgroningen.ch10.jacob.libraryDemo.model.Book;
import nl.miwgroningen.ch10.jacob.libraryDemo.model.Copy;
import nl.miwgroningen.ch10.jacob.libraryDemo.repository.BookRepository;
import nl.miwgroningen.ch10.jacob.libraryDemo.repository.CopyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Author: Jacob Visser
 * <p>
 * Dit is wat het programma doet.
 */
@Controller
@RequestMapping("/copy")
public class CopyController {

private final BookRepository bookRepository;

private final CopyRepository copyRepository;


    public CopyController(BookRepository bookRepository, CopyRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.copyRepository = copyRepository;
    }

    @GetMapping("/buy/{bookId}")
    protected String createNewCopy(@PathVariable("bookId") Long bookId){
        Optional<Book> book = bookRepository.findById(bookId);

        if(book.isPresent()){
            Copy copy = new Copy();
            copy.setBook(book.get());
            copyRepository.save(copy);
        }

        return "redirect:/books/all";
    }
}
