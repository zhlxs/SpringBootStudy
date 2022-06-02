//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.boot.study.bean;

import cn.hutool.core.util.ArrayUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AntiSqlFilter {
    private static final String[] KEY_WORDS = new String[]{";", "\"", "'", "/*", "*/", "--", "exec", "select", "update", "delete", "insert", "alter", "drop", "create", "shutdown"};

    public AntiSqlFilter() {
    }

    public static Map<String, String[]> getSafeParameterMap(Map<String, String[]> parameterMap) {
        Map<String, String[]> map = new HashMap(parameterMap.size());
        Iterator var2 = parameterMap.keySet().iterator();

        while (var2.hasNext()) {
            String key = (String) var2.next();
            String[] oldValues = (String[]) parameterMap.get(key);
            map.put(key, getSafeValues(oldValues));
        }

        return map;
    }

    public static String[] getSafeValues(String[] oldValues) {
        if (!ArrayUtil.isNotEmpty(oldValues)) {
            return null;
        } else {
            String[] newValues = new String[oldValues.length];

            for (int i = 0; i < oldValues.length; ++i) {
                newValues[i] = getSafeValue(oldValues[i]);
            }

            return newValues;
        }
    }

    public static String getSafeValue(String oldValue) {
        if (oldValue != null && !"".equals(oldValue)) {
            StringBuilder sb = new StringBuilder(oldValue);
            String lowerCase = oldValue.toLowerCase();
            String[] var3 = KEY_WORDS;
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String keyWord = var3[var5];

                int x;
                while ((x = lowerCase.indexOf(keyWord)) >= 0) {
                    if (keyWord.length() == 1) {
                        sb.replace(x, x + 1, " ");
                        lowerCase = sb.toString().toLowerCase();
                    } else {
                        sb.delete(x, x + keyWord.length());
                        lowerCase = sb.toString().toLowerCase();
                    }
                }
            }

            return sb.toString();
        } else {
            return oldValue;
        }
    }
}
