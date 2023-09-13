package com.emergency.common.config;

import java.util.Arrays;
import java.util.Optional;

public enum DemandState {
    Create ("1"),
    InProcess("2"),
    Completed("3");
    private String ref;
    DemandState(String ref) {
        this.ref = ref;
    }
    static public Optional<DemandState> byRefIgnoreCase(String givenRef) {
        return Arrays.stream(values()).filter(it -> it.ref.equalsIgnoreCase(givenRef)).findAny();
    }
}
