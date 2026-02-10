package pl.lektury.hexagonal.infrastructure.adapter.out;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.lektury.hexagonal.domain.model.Author;
import pl.lektury.hexagonal.domain.model.AuthorDetails;
import pl.lektury.hexagonal.domain.port.out.AuthorProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.lektury.hexagonal.infrastructure.adapter.in.dto.FreeReadingAuthorDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Component
public class WolneLekturyAdapter implements AuthorProvider {

    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
    private final HttpClient httpClient = HttpClient.newHttpClient();

    @Value( "${external.wolne-lektury.base.url}" )
    private String wolneLekturyBaseUrl;
    @Override
    public List<Author> fetchAll() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri( URI.create(wolneLekturyBaseUrl + "/authors/") )
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send( request, HttpResponse.BodyHandlers.ofString() );

            List<FreeReadingAuthorDto> dtos = objectMapper.readValue(
                    response.body(),
                    new TypeReference<List<FreeReadingAuthorDto>>(){}
            );

            return dtos.stream()
                    .map( freeReadingAuthorDto -> new Author( freeReadingAuthorDto.slug(),freeReadingAuthorDto.name( )))
                    .toList();
        } catch ( IOException | InterruptedException e ) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public Optional<AuthorDetails> fetchById( String authorId ) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri( URI.create( wolneLekturyBaseUrl + "/authors/" + authorId + "/" ) )
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send( request, HttpResponse.BodyHandlers.ofString() );

            if ( response.statusCode() == 404 )
                return Optional.empty();

            FreeReadingAuthorDto dto = objectMapper.readValue( response.body(), FreeReadingAuthorDto.class );
            return Optional.of(new AuthorDetails(authorId,dto.name(),dto.description()));
        }catch ( IOException | InterruptedException e ) {
            throw new RuntimeException( e );
        }

    }
}
