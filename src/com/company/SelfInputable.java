package com.company;

import java.lang.reflect.Field;

public interface SelfInputable extends Inputable {
    public default void input() throws Exception {
        this.input("<"+this.getClass().getSimpleName()+">", 0, false);
    }
    public default void input(String caption) throws Exception { this.input(caption, 0, false); }
    public default void input(int tabs) throws Exception { this.input("", tabs, false); }
    public default void input(String caption, boolean askExceeding) throws Exception { this.input(caption, 0, false); }
    public default void input(int tabs, boolean askExceeding) throws Exception { this.input("", tabs, false); }
    public default void input(String caption, int tabs) throws Exception { this.input(caption, 0, false); }
    public default void input(String caption, int tabs, boolean askExceeding) throws Exception {
        String[] fields = this.getFields();
        String[] titles = this.getFieldsTitle();
        if (fields.length!=titles.length) throw new Exception("Error: Incompatible size of Fields and Fields title.");
        Class c = this.getClass();
        String tabsStr = "";
        if (caption.equals("")) caption = "<"+c.getSimpleName()+">";
        for (int i=0; i<tabs; i++) tabsStr+= "\t";
        System.out.println(tabsStr+"Input "+caption+" content =>: {");
        if (askExceeding) {
            if (Ops.inputBool(tabsStr+"Exceed this object # "+caption)==true) {
                System.out.println(tabsStr+"}");
                return;
            }
        }
        for (int i=0; i<fields.length; i++) {
            Field f = c.getDeclaredField(fields[i]);
            f.setAccessible(true);
            String t = f.getType().getTypeName();
            try {
                if (f.getType().isEnum()) {
                    System.out.println("Enum input is not supported yet...");
                } else if (t.equals("int")) {
                    f.set(this, 0);
                    f.set(this, Ops.inputInt(titles[i], false, tabs + 1));
                } else if (t.equals("char")) {
                    f.set(this, '\0');
                    f.set(this, Ops.inputChar(titles[i], tabs + 1));
                } else if (t.equals("byte") || t.equals("java.lang.Byte")) {
                    f.set(this, 0);
                    f.set(this, Ops.inputByte(titles[i], false, tabs + 1));
                } else if (t.equals("short") || t.equals("java.lang.Short")) {
                    f.set(this, 0);
                    f.set(this, Ops.inputShort(titles[i], false, tabs + 1));
                } else if (t.equals("long") || t.equals("java.lang.Long")) {
                    f.set(this, 0L);
                    f.set(this, Ops.inputLong(titles[i], false, tabs + 1));
                } else if (t.equals("boolean") || t.equals("java.lang.Boolean")) {
                    f.set(this, false);
                    f.set(this, Ops.inputBool(titles[i], tabs + 1));
                } else if (t.equals("String") || t.equals("java.lang.String")) {
                    f.set(this, "");
                    f.set(this, Ops.inputString(titles[i], tabs + 1));
                } else if (t.equals("float") || t.equals("java.lang.Float")) {
                    f.set(this, 0F);
                    f.set(this, Ops.inputFloat(titles[i], false, tabs + 1));
                } else if (t.equals("double") || t.equals("java.lang.Double")) {
                    f.set(this, 0D);
                    f.set(this, Ops.inputDouble(titles[i], false, tabs + 1));
                } else if (t.equals("int[]") || t.equals("java.lang.Integer[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputIntArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("byte[]") || t.equals("java.lang.Byte[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputByteArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("short[]") || t.equals("java.lang.Short[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputShortArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("long[]") || t.equals("java.lang.Long[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputLongArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("boolean[]") || t.equals("java.lang.Boolean[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputBoolArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("String[]") || t.equals("java.lang.String[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputStringArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("float[]") || t.equals("java.lang.Float[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputFloatArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("double[]") || t.equals("java.lang.Double[]")) {
                    f.set(this, null);
                    f.set(this, ArrayOps.inputFloatArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else {
                    f.set(this, null);
                    Class c2 = Class.forName(t);
                    Object o = c2.getDeclaredConstructor(new Class[]{}).newInstance();
                    f.set(this, o);
                    if (f.get(this) instanceof SelfInputable) {
                        Ops.inputObject((SelfInputable) f.get(this), titles[i], tabs + 1, true);
                    } else if (f.get(this) instanceof Inputable) {
                        Ops.inputObject((Inputable) f.get(this), titles[i], tabs + 1, true);
                    } else {
                        Ops.inputObject(f.get(this), titles[i], tabs + 1, true);
                    }
                }
            } catch (IllegalAccessException e) {
                continue;
            } finally {
                f.setAccessible(false);
            }
        }
        System.out.println(tabsStr+"}");
    }
}
