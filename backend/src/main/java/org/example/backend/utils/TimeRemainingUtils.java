package org.example.backend.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeRemainingUtils {
    public static long calculateRemainingTimeInHours(Date endDate) {
        if (endDate == null) {
            return 0;
        }

        Date now = new Date();
        if (now.after(endDate)) {
            return 0;
        }

        long diffInMillis = endDate.getTime() - now.getTime();
        return TimeUnit.MILLISECONDS.toHours(diffInMillis);
    }


    public static String formatRemainingTime(long hours) {
        if (hours <= 0) {
            return "Đã hết hạn";
        }

        long days = hours / 24;
        long remainingHours = hours % 24;

        if (days > 0) {
            return days + " ngày " + remainingHours + " giờ";
        } else {
            return remainingHours + " giờ";
        }
    }

    public static String getFormattedTimeRemaining(Date endDate) {
        long hours = calculateRemainingTimeInHours(endDate);
        return formatRemainingTime(hours);
    }
}