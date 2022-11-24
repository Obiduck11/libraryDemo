package nl.miwgroningen.ch10.jacob.libraryDemo.repository;

import nl.miwgroningen.ch10.jacob.libraryDemo.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository <Copy, Long> {
}
