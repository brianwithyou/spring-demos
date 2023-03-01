package com.example.springjpa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : brian
 * @since 0.1
 */
@Getter
@AllArgsConstructor
public enum GenderEnum {

    /**
     * gender enums
     */
    MALE("male", "男"),
    FEMALE("female", "女"),
    UNKNOWN("unknown", "未知"),
    ;

    private final String value;

    private final String name;

}
