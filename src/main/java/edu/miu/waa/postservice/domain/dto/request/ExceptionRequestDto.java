package edu.miu.waa.postservice.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionRequestDto {
    private long transactionId;
    private Instant dateTime;
    private String principal;
    private String operation;
    private String exceptionType;
}
