package pl.lagodka.hotel.flyweight.nongeneric.strategy.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.lagodka.hotel.flyweight.model.FileType;
import pl.lagodka.hotel.flyweight.nongeneric.strategy.GeneratorStrategy;

@Component
@Slf4j
public class PdfGeneratorStrategy implements GeneratorStrategy {
    @Override
    public FileType getType() {
        return FileType.PDF;
    }

    @Override
    public byte[] generateFile() {
        log.info("Generating PDF file");
        return new byte[0];
    }
}
