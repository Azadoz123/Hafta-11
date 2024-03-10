package dev.patika.ecommerce.core.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class Result {
    private boolean status;
    private String message;
    private String httpCode;

}
