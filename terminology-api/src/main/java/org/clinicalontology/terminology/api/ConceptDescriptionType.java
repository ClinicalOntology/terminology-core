package org.clinicalontology.terminology.api;

import java.util.Arrays;

public enum ConceptDescriptionType {

    FULLY_SPECIFIED_NAME("900000000000003001"),
    DESCRIPTION("900000000000550004"),
    SYNONYM("900000000000013009");

    private final String code;

    ConceptDescriptionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ConceptDescriptionType getByCode(String code) {
        return Arrays.stream(values())
                .filter(v -> v.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
