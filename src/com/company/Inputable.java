package com.company;

import java.lang.reflect.Field;

public interface Inputable {
    public default String[] getFields() {
        Class c = this.getClass();
        Field[] fs = c.getDeclaredFields();
        String[] titles = new String[fs.length];
        for (int i=0; i<fs.length;i++) titles[i] = fs[i].getName();
        return titles;
    }
    public default String[] getFieldsTitle() {
        Class c = this.getClass();
        Field[] fs = c.getDeclaredFields();
        String[] titles = new String[fs.length];
        for (int i=0; i<fs.length;i++) titles[i] = fs[i].getName();
        return titles;
    }

}
