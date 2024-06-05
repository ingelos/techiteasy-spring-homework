package com.example.techiteasyspringhomework.enums;

public enum AvailableSize {

    THIRTY_THREE_INCH(32),
    FORTY_THREE_INCH(43),
    FIFTY_INCH(50),
    FIFTY_FIVE_INCH(55),
    FIFTY_EIGHT_INCH(58),
    SIXTY_FIVE_INCH(65),
    SEVENTY_INCH(70);

    public final int size;

    AvailableSize(int size) {
        this.size = size;
    }


}
