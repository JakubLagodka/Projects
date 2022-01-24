package pl.lagodka.shop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FileControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldReturnReportInXls() throws Exception {
        mockMvc.perform(get("/api/file?fileType=XLS")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnReportInPdf() throws Exception {
        mockMvc.perform(get("/api/file?fileType=PDF")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnReportInCsv() throws Exception {
        mockMvc.perform(get("/api/file?fileType=CSV")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnReportInJson() throws Exception {
        mockMvc.perform(get("/api/file?fileType=JSON")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}
