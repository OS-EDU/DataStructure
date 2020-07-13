package com.quake.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AKA二夕
 * @create 2020-07-13 16:05
 */
public class PolandNotation {

    // 依次将一个逆波兰表达式的数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        // 将suffixExpression按照空格“ ”分开
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
}
