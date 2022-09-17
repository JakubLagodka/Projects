package pl.lagodka.shop.flyweight.generic.strategy.generator.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.flyweight.generic.strategy.generator.FileGeneratorStrategy;
import pl.lagodka.shop.flyweight.model.FileType;

@Component
@Slf4j
public class CsvFileGenerator implements FileGeneratorStrategy {
    @Override
    public FileType getType() {
        return FileType.CSV;
    }

    @Override
    public byte[] generateFile() {
        log.info("Generic CSV");
        return new byte[0];
    }
}
