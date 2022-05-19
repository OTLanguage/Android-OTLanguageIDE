package com.example.android_otlanguageide.activity.variable;

import com.example.android_otlanguageide.activity.item.Check;
import com.example.android_otlanguageide.activity.item.KeyValueItem;
import com.example.android_otlanguageide.activity.item.VariableWork;
import com.example.android_otlanguageide.setting.Setting;

public class LongP extends Setting implements Check, VariableWork {

    private static final String SPECIFIED = "ㅇㅉㅇ";

    @Override
    public boolean check(String line) {
        return line.trim().startsWith(SPECIFIED);
    }

    @Override
    public void start(String line) throws Exception {
        KeyValueItem keyValue = setKeyValue(SPECIFIED, line);
        String key = keyValue.getKey();
        String value = keyValue.getValue();
        LM.put(key, Long.valueOf(value));
        set.add(key);
    }
}