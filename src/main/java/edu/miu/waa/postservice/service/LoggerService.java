package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.request.LoggerRequestDto;

public interface LoggerService {

    void persistLog(LoggerRequestDto loggerRequestDto);
}
