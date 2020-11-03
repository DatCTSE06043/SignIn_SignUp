package demo.api.untils;

import demo.api.constant.Constants;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
    public static final String formatDate1 = "yyyy-MM-dd HH:mm:ss";

    public static String encodeMD5(String input) {
        String output = "";
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            output = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String getContentWithMaxLenght(String content, int maxLenght) {
        String result = "";
        if (content != null) {
            result = content.length() > maxLenght ? content.substring(0, maxLenght) : content;
        }
        return result;
    }

    public static String getCurrentDate(String format) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(Constants.NAME_TIME_ZONE));
        Date date = calendar.getTime();
        return getStringFromDate(date, format);
    }

    public static String getStringFromDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        String reportDate = df.format(date);
        return reportDate;
    }

    public static String toMoney(int amount) {
        return String.format("%,d", amount) + "đ";
    }

}
