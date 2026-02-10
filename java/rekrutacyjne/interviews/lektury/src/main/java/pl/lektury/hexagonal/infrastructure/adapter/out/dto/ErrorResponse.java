package pl.lektury.hexagonal.infrastructure.adapter.out.dto;

import java.time.LocalDateTime;

public record ErrorResponse(int value, String message, LocalDateTime now ) {
}
