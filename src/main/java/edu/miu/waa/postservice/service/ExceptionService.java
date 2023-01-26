package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.request.ExceptionRequestDto;

public interface ExceptionService {

    void persistException(ExceptionRequestDto exceptionRequestDto);
}
