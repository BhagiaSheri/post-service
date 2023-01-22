package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.request.LoggerRequestDto;
import edu.miu.waa.postservice.domain.entity.Logger;
import edu.miu.waa.postservice.repository.LoggerRepository;
import edu.miu.waa.postservice.service.LoggerService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LoggerServiceImpl implements LoggerService {
    private final LoggerRepository loggerRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public LoggerServiceImpl(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Override
    public void persistLog(LoggerRequestDto loggerRequestDto) {
        Logger logger = modelMapper.map(loggerRequestDto, Logger.class);
        loggerRepository.save(logger);
    }
}
