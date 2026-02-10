package pl.lektury.model;

public record Author(String id, String name) {
    public static Author of(String id, String name) {
        return new Author(id, name);
    }
}
