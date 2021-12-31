package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lagodka.shop.flyweight.model.FileType;
import pl.lagodka.shop.flyweight.nongeneric.GeneratorFactory;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {
    private final GeneratorFactory generatorFactory;

    @GetMapping
    public void testFlyweight(@RequestParam FileType fileType){
        generatorFactory.getStrategyByType(fileType).generateFile();
    }

}
