package pl.lagodka.shop.flyweight.generic.strategy.generator.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.flyweight.model.FileType;
import pl.lagodka.shop.flyweight.nongeneric.strategy.GeneratorStrategy;

@Component
@Slf4j
public class MailSenderGenerator implements GeneratorStrategy {
    @Override
    public FileType getType() {
        return null;
    }

    @Override
    public byte[] generateFile() {
        log.info("Sending mail");
        return new byte[0];
    }
}
