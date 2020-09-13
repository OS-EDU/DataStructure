package com.quake.hashtab;

/**
 * @author AKA二夕
 * @create 2020-09-13 14:37
 */
public class HashTabDemo {
}

// 表示一个雇员
class Emp {
    public int id;// 编号
    public String name;// 姓名
    public Emp next;// next默认为null

    // 构造器
    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}