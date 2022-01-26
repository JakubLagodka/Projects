package pl.lagodka.hotel.flyweight.generic.strategy.generator;

import pl.lagodka.hotel.flyweight.generic.strategy.GenericStrategy;
import pl.lagodka.hotel.flyweight.model.FileType;

public interface FileGeneratorStrategy extends GenericStrategy<FileType> {
    byte[] generateFile();
}
