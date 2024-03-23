package com.example.supplierservice.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateConvertor {

    public static LocalDateTime toDate(long epochSeconds){
        return LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC);
    }

    public static long toEpochSeconds(LocalDateTime localDateTime){
        return localDateTime.toEpochSecond(ZoneOffset.UTC);
    }
}
