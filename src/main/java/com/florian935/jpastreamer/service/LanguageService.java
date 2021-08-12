package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Language;
import com.florian935.jpastreamer.dto.SimpleEmployeeDto;
import com.florian935.jpastreamer.dto.LanguageDto;
import com.florian935.jpastreamer.dto.SimpleLanguageDto;

import java.util.List;
import java.util.Map;

public interface LanguageService extends CrudService<Language, Integer> {

    List<LanguageDto> getAll();

    Map<SimpleLanguageDto, List<SimpleEmployeeDto>> getEmployeesPerLanguages();
}
