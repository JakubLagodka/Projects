package pl.lagodka.shop.flyweight.nongeneric.strategy;

import pl.lagodka.shop.flyweight.model.FileType;

public interface GeneratorStrategy {

    FileType getType();

    byte[] generateFile();
}
