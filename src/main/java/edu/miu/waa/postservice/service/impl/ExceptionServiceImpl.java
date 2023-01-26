package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.request.ExceptionRequestDto;
import edu.miu.waa.postservice.domain.entity.Exception;
import edu.miu.waa.postservice.repository.ExceptionRepository;
import edu.miu.waa.postservice.service.ExceptionService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExceptionServiceImpl implements ExceptionService {
    private final ExceptionRepository exceptionRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ExceptionServiceImpl(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    @Override
    public void persistException(ExceptionRequestDto exceptionRequestDto) {
        Exception exception = modelMapper.map(exceptionRequestDto, Exception.class);
        exceptionRepository.save(exception);

    }
}
