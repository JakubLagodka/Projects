package pl.lagodka.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lagodka.hotel.flyweight.generic.GenericFactory;
import pl.lagodka.hotel.flyweight.generic.strategy.generator.FileGeneratorStrategy;
import pl.lagodka.hotel.flyweight.model.FileType;
import pl.lagodka.hotel.flyweight.nongeneric.GeneratorFactory;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {
    private final GeneratorFactory generatorFactory;

    private final GenericFactory<FileType, FileGeneratorStrategy> genericFactory;

    @GetMapping
    public ResponseEntity<byte[]> testFlyweight(@RequestParam FileType fileType){
        //niegenerycznie
        //generatorFactory.getStrategyByType(fileType).generateFile();
        //generycznie
        byte[] file = genericFactory.getStrategyByType(fileType).generateFile();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_LENGTH, Integer.toString(file.length));
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=report." + fileType.toString().toLowerCase());
        return ResponseEntity.ok().headers(httpHeaders).body(file);
    }

}
