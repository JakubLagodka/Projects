package pl.lektury.hexagonal.infrastructure.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lektury.hexagonal.domain.model.AuthorDetails;
import pl.lektury.hexagonal.domain.port.in.GetAuthorsUseCase;
import pl.lektury.hexagonal.infrastructure.adapter.in.dto.AuthorDetailResponse;
import pl.lektury.hexagonal.infrastructure.adapter.in.dto.AuthorResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final GetAuthorsUseCase getAuthorsUseCase;

    public AuthorController( GetAuthorsUseCase getAuthorsUseCase ) {
        this.getAuthorsUseCase = getAuthorsUseCase;
    }
        @GetMapping
        public List<AuthorResponse> listAuthors( Optional<String> name ){
            return getAuthorsUseCase.getAuthors( name ).stream().map( author -> new AuthorResponse(author.id(),author.name())).toList();
        }

        @GetMapping("/{id}")
    public AuthorDetailResponse getDetails( @PathVariable String id ){
        AuthorDetails authorDetails = getAuthorsUseCase.getAuthorDetails(id);
        return new AuthorDetailResponse(authorDetails.id(),authorDetails.name(), authorDetails.description());
        }
    }
