package finki.ukim.mk.libraryapp.repository;

import finki.ukim.mk.libraryapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
