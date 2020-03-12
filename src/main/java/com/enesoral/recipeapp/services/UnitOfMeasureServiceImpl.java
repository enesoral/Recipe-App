package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.domain.UnitOfMeasure;
import com.enesoral.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Set<UnitOfMeasure> findAll() {
        return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }
}
