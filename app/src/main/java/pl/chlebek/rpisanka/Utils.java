package pl.chlebek.rpisanka;

import java.util.Collections;
import java.util.List;

public class Utils {

    public static String join(String[] array, String separator) {
        StringBuilder sbStr = new StringBuilder();
        for (int i = 0, il = array.length; i < il; i++) {
            if (i > 0)
                sbStr.append(separator);
            sbStr.append(array[i]);
        }
        return sbStr.toString();
    }

    public static String join(String[] array) {
        return join(array, ",");
    }

    public static String join(List<String> array, String separator) {
        StringBuilder sbStr = new StringBuilder();
        for (int i = 0, il = array.size(); i < il; i++) {
            if (i > 0)
                sbStr.append(separator);
            sbStr.append(array.get(i));
        }
        return sbStr.toString();
    }

    public static String join(List<String> array) {
        return join(array, ",");
    }

    public static String[] split(String string, String separator) {
        String[] r = {};
        if(string.length() == 0)
            return r;
        else return string.split(separator);
    }

    public static String[] split(String string) {
        return split(string, ",");
    }

}
