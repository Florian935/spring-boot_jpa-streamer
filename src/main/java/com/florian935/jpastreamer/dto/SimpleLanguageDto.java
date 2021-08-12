package com.florian935.jpastreamer.dto;

import com.florian935.jpastreamer.domain.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class SimpleLanguageDto {

    Integer languageId;
    String name;

    public SimpleLanguageDto(Language language) {

        this.languageId = language.getLanguageId();
        this.name = language.getName();
    }
}
