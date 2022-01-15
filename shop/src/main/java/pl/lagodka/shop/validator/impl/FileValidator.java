package pl.lagodka.shop.validator.impl;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.lagodka.shop.validator.FileValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileValidator implements ConstraintValidator<FileValid, MultipartFile> {
    private static final List<String> EXTENSIONS = Arrays.asList("png", "jpg");

    @Override
    public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext constraintValidatorContext) {
        return EXTENSIONS.contains(FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
    }
}
