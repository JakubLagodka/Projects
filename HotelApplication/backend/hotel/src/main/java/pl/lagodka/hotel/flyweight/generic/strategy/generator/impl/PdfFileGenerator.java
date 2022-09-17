package pl.lagodka.hotel.flyweight.generic.strategy.generator.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.lagodka.hotel.flyweight.generic.strategy.generator.FileGeneratorStrategy;
import pl.lagodka.hotel.flyweight.model.FileType;

@Component
@Slf4j
@RequiredArgsConstructor
public class PdfFileGenerator implements FileGeneratorStrategy {


    @Override
    public FileType getType() {
        return FileType.PDF;
    }

    @Override
    public byte[] generateFile() {
        log.info("Generic PDF");

        return new byte[0];
    }
}
