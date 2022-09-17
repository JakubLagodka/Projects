package pl.lagodka.shop.flyweight.nongeneric.strategy.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.flyweight.model.FileType;
import pl.lagodka.shop.flyweight.nongeneric.strategy.GeneratorStrategy;

@Component
@Slf4j
public class XlsGenerationStrategy implements GeneratorStrategy {
    @Override
    public FileType getType() {
        return FileType.XLS;
    }

    @Override
    public byte[] generateFile() {
        log.info("Generating XLS file");
        return new byte[0];
    }
}
