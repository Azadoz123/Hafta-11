package patika.dev.libraryControlSystem.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.libraryControlSystem.entitties.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
