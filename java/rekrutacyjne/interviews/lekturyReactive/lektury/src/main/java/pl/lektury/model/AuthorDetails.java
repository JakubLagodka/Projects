package pl.lektury.model;

public record AuthorDetails(String id, String name, String description) {
    public static AuthorDetails of(String id, String name, String description) {
        return new AuthorDetails(id, name,description);
    }
}
