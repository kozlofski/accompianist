package dev.kozlofski.accompianist.song.domain.model;

public enum MeterUnits {
    SIXTEENTHS(16), EIGHTS(8), QUARTERS(4), HALVES(2);

    private final int value;

    MeterUnits(int value) {
        this.value = value;
    }
}
