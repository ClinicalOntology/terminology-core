package org.clinicalontology.terminology.api.model;

import java.util.Arrays;

/**
 * The type of description.  Associated codes are SNOMED-CT codes.
 */
public enum DescriptionType {

    FULLY_SPECIFIED_NAME("900000000000003001"),
    DEFINITION("900000000000550004"),
    SYNONYM("900000000000013009");

    private final String code;

    DescriptionType(String code) {
        this.code = code;
    }

    /**
     * @return The SNOMED-CT code for this description.
     */
    public String getCode() {
        return code;
    }

    /**
     * Looks up the description type given its SNOMED-CT code.
     *
     * @param code The SNOMED-CT code.
     * @return The associated description type (possibly null).
     */
    public static DescriptionType getByCode(String code) {
        return Arrays.stream(values())
                .filter(v -> v.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
