package com.emergency.configuration.nomenclator.config;

import java.util.Arrays;
import java.util.Optional;

public enum NomenclatorType {
    ECODE("e_code"),
    HUNIT("h_unit"),
    MOVILTYPE("m_type"),
    SERVICETYPE("s_type"),
    DOCUMENTTYPE("d_type");

    private String ref;
    NomenclatorType(String ref) {
        this.ref = ref;
    }
    static public Optional<NomenclatorType> byRefIgnoreCase(String givenRef) {
        return Arrays.stream(values()).filter(it -> it.ref.equalsIgnoreCase(givenRef)).findAny();
    }
}
