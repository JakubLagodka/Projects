import java.time.LocalDate;

public record Book(String title, LocalDate releaseDate, String isbn) {
    public int compareTo(Book b){
        return this.isbn.compareTo(b.isbn);
    }
}
