package com.ivanmix.resume.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by ivan on 04.06.2016.
 */
public enum LanguageLevel {

    BEGINNER,

    ELEMENTARY,

    PRE_INTERMEDIATE,

    INTERMEDIATE,

    UPPER_INTERMEDIATE,

    ADVANCED,

    PROFICIENCY;

    public int getSliderIntValue(){
        return ordinal();
    }

    public String getDbValue(){
        return name().toLowerCase();
    }

    @Converter
    public static class PersistJPAConverter implements AttributeConverter<LanguageLevel, String> {
        @Override
        public String convertToDatabaseColumn(LanguageLevel attribute) {
            return attribute.getDbValue();
        }
        @Override
        public LanguageLevel convertToEntityAttribute(String dbValue) {
            return LanguageLevel.valueOf(dbValue.toUpperCase());
        }
    }
}
