package patika.dev.libraryControlSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.libraryControlSystem.entitties.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer> {
}
