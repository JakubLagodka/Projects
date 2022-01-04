package pl.lagodka.shop.flyweight.generic.strategy.generator.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Component;
import pl.lagodka.shop.flyweight.generic.strategy.generator.FileGeneratorStrategy;
import pl.lagodka.shop.flyweight.model.FileType;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.repository.ProductRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class XlsFileGenerator implements FileGeneratorStrategy {

    private final ProductRepository productRepository;
    @Override
    public FileType getType() {
        return FileType.XLS;
    }

    @Override
    public byte[] generateFile() {
        log.info("Generic XLS");
        try {
            Workbook workbook = WorkbookFactory.create(false);
            Sheet sheet = workbook.createSheet("report");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("id");
            row.createCell(1).setCellValue("name");
            row.createCell(2).setCellValue("price");
            row.createCell(3).setCellValue("quantity");
            List<Product> products = productRepository.findAll();
            for (int i = 0; i < products.size(); i++) {
                row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(products.get(i).getId());
                row.createCell(1).setCellValue(products.get(i).getName());
                row.createCell(2).setCellValue(products.get(i).getPrice());
                row.createCell(3).setCellValue(products.get(i).getQuantity());
            }
            sheet.setAutoFilter(new CellRangeAddress(0, products.size(), 0, 3));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            log.error("Failed to generate excel", e);
        }
        return new byte[0];
    }
}
