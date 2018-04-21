package com.wanle;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TemplateTest {

    public static final String DEFAULT_SPLIT = "$";

    public static void main(String[] args) {
        String template="aaa${a},ddfdf${bb}";
        String params[]={"哈哈","哦哦"};
        Map<String,Object> jsonMap=new HashMap<>();
        jsonMap.put("a","哈哈");
        jsonMap.put("bb","嗯嗯");
        jsonMap.put("cc","o嗯");

        for (Object s : jsonMap.keySet()) {
            template = template.replaceAll("\\$\\{".concat(s.toString()).concat("\\}")
                    , jsonMap.get(s.toString()).toString());
        }
        System.out.println(template);

    }

}
