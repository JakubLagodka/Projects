package pl.lagodka.shop.flyweight.generic.strategy.generator;

import pl.lagodka.shop.flyweight.generic.strategy.GenericStrategy;
import pl.lagodka.shop.flyweight.model.FileType;

public interface FileGeneratorStrategy extends GenericStrategy<FileType> {
    byte[] generateFile();
}
