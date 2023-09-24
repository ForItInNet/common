package com.foryouinnet.common.util;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public final class DateUtil {

    public static ZonedDateTime localDataTimeToZonedLocalDateTime(@NonNull LocalDateTime localDateTime) {
        return ZonedDateTime.of(localDateTime, TimeZone.getDefault().toZoneId());
    }
}
