package thent.kuzuki.vn.lab5.helper;

import android.app.Application;
import android.content.Context;

public class GetTimeAgo extends Application {
    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 60 * HOUR_MILLIS;

    public static String getTimeAgo(long time, Context ctx, String day) {
        if (time < 100000000000L) {
            time *= 1000;
        }
        long now = System.currentTimeMillis();
        if (time > now || time <= 0) {
            return "just now";
        }

        final long diff = now - time;
        if (diff < MINUTE_MILLIS) {
            return "just now";
        } else if (diff < 2 * MINUTE_MILLIS) {
            return "a minute ago";
        } else if (diff < 50 * MINUTE_MILLIS) {
            return diff / MINUTE_MILLIS + " minutes ago";
        } else if (diff < 90 * MINUTE_MILLIS) {
            return "a hour ago";
        } else if (diff < 24 * HOUR_MILLIS) {
            return diff / HOUR_MILLIS + " hours ago";
        } else if (diff < 48 * HOUR_MILLIS || diff / DAY_MILLIS == 0) {
            return day;
        } else if (diff > DAY_MILLIS) {
            return day;
        } else {
            return diff / DAY_MILLIS + " days ago";
        }

    }
}
