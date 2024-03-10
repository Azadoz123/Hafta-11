package patika.dev.libraryControlSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import patika.dev.libraryControlSystem.entitties.Publisher;

public interface PublisherRepo extends JpaRepository<Publisher,Integer> {
}
