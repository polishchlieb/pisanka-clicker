package pl.chlebek.rpisanka;

import java.util.List;

public class Utils {

    public static String join(List<String> list) {
        return list == null || list.size() == 0 ? "" : list.size() == 1 ? list.get(0) : list.subList(0, list.size() - 1).toString().replaceAll("^.|.$", "") + "," + list.get(list.size() - 1);
    }

}
