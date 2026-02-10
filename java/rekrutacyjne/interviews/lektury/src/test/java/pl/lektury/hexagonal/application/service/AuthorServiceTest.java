package pl.lektury.hexagonal.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.lektury.hexagonal.domain.exception.AuthorNotFoundException;
import pl.lektury.hexagonal.domain.model.Author;
import pl.lektury.hexagonal.domain.port.out.AuthorProvider;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith ( MockitoExtension.class )
class AuthorServiceTest {

    private AuthorProvider authorProvider;
    private AuthorService authorService;
    private List<Author> mockAuthors;
    @BeforeEach
    void setUp() {
        authorProvider = Mockito.mock( AuthorProvider.class );
        authorService = new AuthorService( authorProvider );
        mockAuthors = List.of(
                new Author( "adam-mickiewicz", "Adam Mickiewicz" ),
                new Author( "juliusz-slowacki", "Juliusz Słowacki" )
        );
    }

    @Test
    void shouldReturnAllAuthors() {
        //given
        when( authorProvider.fetchAll() ).thenReturn( mockAuthors );

        //when
        List<Author> result = authorService.getAuthors( Optional.empty() );

        //then
        assertEquals(2,result.size());
    }
    @Test
    void shouldFilterAuthorsCaseInsensitive() {
        //given
        when( authorProvider.fetchAll() ).thenReturn( mockAuthors );

        //when
        List<Author> result = authorService.getAuthors( Optional.of( "adam" ) );

        //then
        assertEquals(1,result.size());
        assertEquals("Adam Mickiewicz",result.get(0).name());
    }
    @Test
    void shouldReturnEmptyListWhenNoMatch() {
        //given
        when( authorProvider.fetchAll() ).thenReturn( mockAuthors );

        //when
        List<Author> result = authorService.getAuthors( Optional.of( "NonExistent" ) );

        //then
        assertEquals(0,result.size());
    }
    @Test
    void shouldThrowExceptionWhenAuthorNotFound() {
        //given
        String nonExistentId = "NonExistent";
        when( authorProvider.fetchById(nonExistentId  ) ).thenReturn( Optional.empty() );

        //when
        AuthorNotFoundException authorNotFoundException = assertThrows( AuthorNotFoundException.class, () -> authorService.getAuthorDetails( nonExistentId ) );

        //then
        assertTrue( authorNotFoundException.getMessage().contains( nonExistentId ) );
    }
}