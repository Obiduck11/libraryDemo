package nl.miwgroningen.ch10.jacob.libraryDemo.repository;

import nl.miwgroningen.ch10.jacob.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
