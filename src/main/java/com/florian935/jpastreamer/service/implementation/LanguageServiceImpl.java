package com.florian935.jpastreamer.service.implementation;

import com.florian935.jpastreamer.domain.Language;
import com.florian935.jpastreamer.domain.Language$;
import com.florian935.jpastreamer.dto.LanguageDto;
import com.florian935.jpastreamer.dto.SimpleEmployeeDto;
import com.florian935.jpastreamer.dto.SimpleLanguageDto;
import com.florian935.jpastreamer.repository.LanguageRepository;
import com.florian935.jpastreamer.service.LanguageService;
import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.speedment.jpastreamer.streamconfiguration.StreamConfiguration.of;
import static java.util.stream.Collectors.toMap;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LanguageServiceImpl implements LanguageService {

    LanguageRepository languageRepository;
    JPAStreamer jpaStreamer;

    @Override
    public List<Language> findAll() {

        return jpaStreamer.stream(Language.class).toList();
    }

    @Override
    public List<LanguageDto> getAll() {

        return jpaStreamer.stream(Language.class)
                .map(LanguageDto::new)
                .toList();
    }

    @Override
    public Language findById(Integer integer) {
        return null;
    }

    @Override
    public Language saveOne(Language language) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Language updateOne(Integer integer, Language language) {
        return null;
    }

    @Override
    public Map<SimpleLanguageDto, List<SimpleEmployeeDto>> getEmployeesPerLanguages() {

        return jpaStreamer.stream(of(Language.class).joining(Language$.employees))
                .collect(
                        toMap(
                                SimpleLanguageDto::new,
                                language -> language.getEmployees()
                                        .stream()
                                        .map(SimpleEmployeeDto::new)
                                        .toList()
                        )
                );
    }
}
