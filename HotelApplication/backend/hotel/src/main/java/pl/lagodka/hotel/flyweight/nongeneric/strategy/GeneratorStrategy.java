package pl.lagodka.hotel.flyweight.nongeneric.strategy;

import pl.lagodka.hotel.flyweight.model.FileType;

public interface GeneratorStrategy {

    FileType getType();

    byte[] generateFile();
}
