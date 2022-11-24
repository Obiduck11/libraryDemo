package nl.miwgroningen.ch10.jacob.libraryDemo.controller;

import nl.miwgroningen.ch10.jacob.libraryDemo.model.Book;
import nl.miwgroningen.ch10.jacob.libraryDemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Author: Jacob Visser
 * <p>
 * geeft toegang tot alle paginas over boeken.
 */

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping({"/books/all", "/"})
    protected String showBookOverview(Model model){
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }

    @GetMapping("/books/new")
    protected String showNewBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/books/new")
    protected String saveBook(@ModelAttribute("book") Book bookToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            bookRepository.save(bookToBeSaved);
        }
        return "redirect:/books/all";
    }

    @GetMapping("/books/edit/{bookId}")
    protected String showEditBookForm(@PathVariable("bookId") Long bookId, Model model){
        Optional<Book> book =bookRepository.findById(bookId);

        if(book.isPresent()){
            model.addAttribute("book", book.get());
            return "bookForm";
        }

        return "redirect:/books/all";
    }

    @GetMapping("/books/delete/{bookId}")
    protected String deleteBook(@PathVariable("bookId") Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            bookRepository.delete(book.get());
        }

        return "redirect:/books/all";
    }

    @GetMapping("/books/details/{bookId}")
    protected String showBookDetails(@PathVariable("bookId") Long bookId, Model model){
        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()){
            model.addAttribute("book", book.get());
            return "bookDetails";
        }
        return "redirect:/books/all";
    }


}
