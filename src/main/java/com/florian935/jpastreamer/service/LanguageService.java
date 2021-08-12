package com.florian935.jpastreamer.service;

import com.florian935.jpastreamer.domain.Language;
import com.florian935.jpastreamer.dto.LanguageDto;

import java.util.List;

public interface LanguageService extends CrudService<Language, Integer> {

    List<LanguageDto> getAll();
}
