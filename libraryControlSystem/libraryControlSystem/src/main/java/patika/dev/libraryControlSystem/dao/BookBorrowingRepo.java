package patika.dev.libraryControlSystem.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.libraryControlSystem.entitties.BookBorrowing;

public interface BookBorrowingRepo extends JpaRepository<BookBorrowing,Integer> {
}
