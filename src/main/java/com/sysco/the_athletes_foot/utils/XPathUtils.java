package com.sysco.the_athletes_foot.utils;

import java.util.concurrent.ThreadLocalRandom;

public class XPathUtils {

    public static String generateXPath(String xpath, String replace, String with){
        return xpath.replaceFirst(replace,with);
    }

    public static String generateXPathInRange(String xpath, String replace, int min, int max){
        int subCategroyNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        String with = Integer.toString(subCategroyNumber);
        return xpath.replaceFirst(replace,with);
    }
}
