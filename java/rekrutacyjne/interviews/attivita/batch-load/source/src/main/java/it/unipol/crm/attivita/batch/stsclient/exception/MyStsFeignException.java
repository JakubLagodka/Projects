package it.unipol.crm.attivita.batch.stsclient.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MyStsFeignException extends RuntimeException{

    private String requestId;
    private Integer statusFromFeignClient;
    private String errorNameFromFeignClient;
    private String messageFromFeignClient;
    private String urlFromFeignClient;

    public MyStsFeignException(String message, String requestId, Integer statusFromFeignClient,
                               String errorNameFromFeignClient, String messageFromFeignClient, String urlFromFeignClient) {

        super(message);
        this.requestId = requestId;
        this.statusFromFeignClient = statusFromFeignClient;
        this.errorNameFromFeignClient = errorNameFromFeignClient;
        this.messageFromFeignClient = messageFromFeignClient;
        this.urlFromFeignClient = urlFromFeignClient;
    }
}
