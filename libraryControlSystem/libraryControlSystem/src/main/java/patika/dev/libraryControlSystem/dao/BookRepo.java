package patika.dev.libraryControlSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.libraryControlSystem.entitties.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
