package com.florian935.jpastreamer.controller;

import com.florian935.jpastreamer.dto.LanguageDto;
import com.florian935.jpastreamer.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1.0/languages")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class LanguageController {

    LanguageService languageService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    List<LanguageDto> getAllLanguages() {

        return languageService.getAll();
    }
}
