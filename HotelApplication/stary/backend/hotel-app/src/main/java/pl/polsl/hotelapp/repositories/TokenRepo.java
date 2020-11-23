package pl.polsl.hotelapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelapp.models.Token;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {

    //TODO zrobić Optional i obsługę błędów(filmik)
    public Token findByValue(String value);
}
