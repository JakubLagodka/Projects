package pl.lagodka.hotel.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import java.util.Date;

public class Token {
    @ApiModelProperty(required = true, example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYW5vIiwiZXhwIjoxNTc0OTQ1NDY3LCJpYXQiOjE1NzQ5Mjc0Njd9.1nVS9zoTiJ7ZRBLRsKwxf2rrcTxn6M6HfCRHNvnI5nC-52cvjtR0PiLMjU4XQaUkKPywttOi8OS6jeloHbQ8LA")
    @NonNull
    private String token;

    @ApiModelProperty(required = true, position = 1)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NonNull
    private Date expirationDate;

    public Token() {
    }

    @NonNull
    public String getToken() {
        return token;
    }

    public void setToken(@NonNull String token) {
        this.token = token;
    }

    @NonNull
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(@NonNull Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
