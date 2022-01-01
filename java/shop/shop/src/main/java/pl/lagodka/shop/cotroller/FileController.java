package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lagodka.shop.flyweight.generic.GenericFactory;
import pl.lagodka.shop.flyweight.generic.strategy.generator.FileGeneratorStrategy;
import pl.lagodka.shop.flyweight.model.FileType;
import pl.lagodka.shop.flyweight.nongeneric.GeneratorFactory;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {
    private final GeneratorFactory generatorFactory;

    private final GenericFactory<FileType, FileGeneratorStrategy> genericFactory;

    @GetMapping
    public void testFlyweight(@RequestParam FileType fileType){
        //niegenerycznie
        //generatorFactory.getStrategyByType(fileType).generateFile();
        //generycznie
        genericFactory.getStrategyByType(fileType).generateFile();
    }

}
