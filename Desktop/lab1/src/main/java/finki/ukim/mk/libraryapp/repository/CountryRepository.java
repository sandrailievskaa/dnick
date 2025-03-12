package finki.ukim.mk.libraryapp.repository;

import finki.ukim.mk.libraryapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
