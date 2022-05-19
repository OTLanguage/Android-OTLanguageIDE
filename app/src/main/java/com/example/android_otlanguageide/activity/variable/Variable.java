package com.example.android_otlanguageide.activity.variable;

import com.example.android_otlanguageide.activity.item.Check;
import com.example.android_otlanguageide.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class Variable extends VariableItem implements Check {

    /**
     * 변수 :[변수명][공백] 을 변수 값으로 대체함
     * @param line 한줄을 받아옴
     */
    public List<String> getVar(String line) {
        List<String> list = new ArrayList<>();
        String[] words = line.split(" ");
        for (String word : words) {
            if (!word.isEmpty() && word.contains(":")) {
                int start = word.indexOf(":") + 1;
                list.add(word.substring(start));
            }
        }
        return list;
    }

    /**
     * 공백 단위로 쪼갠 뒤
     * @param line 첫 번째 줄 받아오기
     * @return 변수가 존재시 값을 받아옴
     */
    @Override
    public boolean check(String line) {
        String[] keys = line.split(" ");
        for (String key : keys) {
            if (!key.isEmpty() && key.contains(":")) {
                int start = key.indexOf(":")+1;
                return set.contains(key.substring(start));
            }
        } return false;
    }
}
