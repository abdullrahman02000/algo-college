package com.company;

import java.lang.reflect.Field;
import java.util.Scanner;
import java.lang.reflect.Method;
public class Ops {
    public static Scanner stdin = new Scanner(System.in);
    // Input Integer function
    public static int inputInt() { return inputInt("", false, 0); }
    public static int inputInt(int tabs) { return inputInt("", false, tabs); }
    public static int inputInt(String caption) { return inputInt(caption, false, 0); }
    public static int inputInt(String caption, int tabs) { return inputInt(caption, false, tabs); }
    public static int inputInt(String caption, boolean onlyPositive) { return inputInt(caption, onlyPositive, 0); }
    public static int inputInt(String caption, boolean onlyPositive, int tabs) {
        int n = 0;
        if (caption.equals("")) caption="<int>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            try {
                System.out.print(tabsStr);
                System.out.print("Input "+caption+" =>: ");
                n = Integer.parseInt(stdin.nextLine());
                if (n>0 && onlyPositive) break;
                else if (!onlyPositive) break;
            } catch (Exception e) {
                continue;
            }
        } while (true);
        return n;
    }
    // Input Double function
    public static double inputDouble() { return inputDouble("", false, 0); }
    public static double inputDouble(int tabs) { return inputDouble("", false, tabs); }
    public static double inputDouble(String caption) { return inputDouble(caption, false, 0); }
    public static double inputDouble(String caption, int tabs) { return inputDouble(caption, false, tabs); }
    public static double inputDouble(String caption, boolean onlyPositive) { return inputDouble(caption, onlyPositive, 0); }
    public static double inputDouble(String caption, boolean onlyPositive, int tabs) {
        double n = 0.0D;
        if (caption.equals("")) caption="<double>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            try {
                System.out.print(tabsStr);
                System.out.print("Input "+caption+" =>: ");
                n = Double.parseDouble(stdin.nextLine());
                if (n>0.0D && onlyPositive) break;
                else if (!onlyPositive) break;
            } catch (Exception e) {
                continue;
            }
        } while (true);
        return n;
    }
    // Input Float function
    public static float inputFloat() { return inputFloat("", false, 0); }
    public static float inputFloat(int tabs) { return inputFloat("", false, tabs); }
    public static float inputFloat(String caption) { return inputFloat(caption, false, 0); }
    public static float inputFloat(String caption, int tabs) { return inputFloat(caption, false, tabs); }
    public static float inputFloat(String caption, boolean onlyPositive) { return inputFloat(caption, onlyPositive, 0); }
    public static float inputFloat(String caption, boolean onlyPositive, int tabs) {
        float n = 0.0F;
        if (caption.equals("")) caption="<float>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            try {
                System.out.print(tabsStr);
                System.out.print("Input "+caption+" =>: ");
                n = Float.parseFloat(stdin.nextLine());
                if (n>0.0F && onlyPositive) break;
                else if (!onlyPositive) break;
            } catch (Exception e) {
                continue;
            }
        } while (true);
        return n;
    }
    // Input String function
    public static String inputString() { return inputString("", 0); }
    public static String inputString(int tabs) { return inputString("", tabs); }
    public static String inputString(String caption) { return inputString(caption, 0); }
    public static String inputString(String caption, int tabs) {
        String n = "";
        if (caption.equals("")) caption="<String>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            System.out.print(tabsStr);
            System.out.print("Input "+caption+" =>: ");
            n = stdin.nextLine();
            if (!n.equals("")) break;
        } while (true);
        return n;
    }
    // Input Char function
    public static char inputChar() { return inputChar("", 0); }
    public static char inputChar(int tabs) { return inputChar("", tabs); }
    public static char inputChar(String caption) { return inputChar(caption, 0); }
    public static char inputChar(String caption, int tabs) {
        if (caption==null || caption.equals("")) caption="<char>";
        return inputString(caption, tabs).charAt(0);
    }
    // get option function
    public static int getOption(String[][] options, String value) { return getOption(options, value, false); }
    public static int getOption(String[][] options, String value, boolean caseSensitive) {
        if (options.length<=0) return -1;
        for (int i=0; i<options.length; i++) {

            if (options[i].length<=0) continue;
            for (int j=0; j<options[i].length; j++) {
                if (caseSensitive) {
                    if (value.equals(options[i][j])) return i;
                } else {
                    if (value.toLowerCase().equals(options[i][j].toLowerCase())) return i;
                }
            }
        }
        return -1;
    }
    // Input option function
    public static int inputOption(String[][] options) { return inputOption(options, "", false, 0); }
    public static int inputOption(String[][] options, String caption, boolean caseSensitive, int tabs) {
        int op = -1;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        String topLevel = (tabsStr.equals(""))? "" : tabsStr.substring(0, tabsStr.length()-1);
        System.out.println(topLevel+"{");
        System.out.print(tabsStr+"Input cases: ");
        for (int i=0; i<options.length; i++) {
            if (options[i].length>0) {
                System.out.print("[");
                for (int j=0; j<options[i].length; j++) {
                    System.out.print("\""+options[i][j]+"\"");
                    if (j<options[i].length-1) System.out.print(", ");
                }
                System.out.print("]");
                if (i<options.length-1) System.out.print(", ");
            } else continue;
        }
        System.out.println();
        String str = inputString(caption, tabs);
        op = getOption(options, str, caseSensitive);
        System.out.println(topLevel+"}");
        return op;
    }
    // Input Boolean function
    public static boolean inputBool() { return inputBool("", 0); }
    public static boolean inputBool(int tabs) { return inputBool("", tabs); }
    public static boolean inputBool(String caption) { return inputBool(caption, 0); }
    public static boolean inputBool(String caption, int tabs) {
        String n = "";
        int op = 0;
        if (caption.equals("")) caption="<boolean>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            System.out.print(tabsStr);
            System.out.print(caption+"? =>: ");
            n = stdin.nextLine();
            op = getOption(new String[][] {{"n", "no", "f", "false", "0"}, {"y", "yes", "t", "true", "1"}}, n);
            if (op!=-1) break;
        } while (true);
        return (op==1);
    }
    // Input Short
    public static short inputShort() { return inputShort("", false, 0); }
    public static short inputShort(int tabs) { return inputShort("", false, tabs); }
    public static short inputShort(String caption) { return inputShort(caption, false, 0); }
    public static short inputShort(String caption, int tabs) { return inputShort(caption, false, tabs); }
    public static short inputShort(String caption, boolean onlyPositive) { return inputShort(caption, onlyPositive, 0); }
    public static short inputShort(String caption, boolean onlyPositive, int tabs) {
        short n = 0;
        if (caption.equals("")) caption="<short>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            try {
                System.out.print(tabsStr);
                System.out.print("Input "+caption+" =>: ");
                n = Short.parseShort(stdin.nextLine());
                if (n>0 && onlyPositive) break;
                else if (!onlyPositive) break;
            } catch (Exception e) {
                continue;
            }
        } while (true);
        return n;
    }
    // Input Byte
    public static byte inputByte() { return inputByte("", false, 0); }
    public static byte inputByte(int tabs) { return inputByte("", false, tabs); }
    public static byte inputByte(String caption) { return inputByte(caption, false, 0); }
    public static byte inputByte(String caption, int tabs) { return inputByte(caption, false, tabs); }
    public static byte inputByte(String caption, boolean onlyPositive) { return inputByte(caption, onlyPositive, 0); }
    public static byte inputByte(String caption, boolean onlyPositive, int tabs) {
        byte n = 0;
        if (caption.equals("")) caption="<byte>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            try {
                System.out.print(tabsStr);
                System.out.print("Input "+caption+" =>: ");
                n = Byte.parseByte(stdin.nextLine());
                if (n>0 && onlyPositive) break;
                else if (!onlyPositive) break;
            } catch (Exception e) {
                continue;
            }
        } while (true);
        return n;
    }
    // Input Long
    public static long inputLong() { return inputLong("", false, 0); }
    public static long inputLong(int tabs) { return inputLong("", false, tabs); }
    public static long inputLong(String caption) { return inputLong(caption, false, 0); }
    public static long inputLong(String caption, int tabs) { return inputLong(caption, false, tabs); }
    public static long inputLong(String caption, boolean onlyPositive) { return inputLong(caption, onlyPositive, 0); }
    public static long inputLong(String caption, boolean onlyPositive, int tabs) {
        long n = 0;
        if (caption.equals("")) caption="<long>";
        if (tabs<0) tabs=0;
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        do {
            try {
                System.out.print(tabsStr);
                System.out.print("Input "+caption+" =>: ");
                n = Long.parseLong(stdin.nextLine());
                if (n>0 && onlyPositive) break;
                else if (!onlyPositive) break;
            } catch (Exception e) {
                continue;
            }
        } while (true);
        return n;
    }
    // Input Object
    public static Object inputObject(Object prev) throws Exception { return inputObject(prev, "",  0, false); }
    public static Object inputObject(Object prev, String caption) throws Exception { return inputObject(prev, caption, 0, false); }
    public static Object inputObject(Object prev, int tabs) throws Exception { return inputObject(prev, "", tabs, false); }
    public static Object inputObject(Object prev, boolean askExceeding) throws Exception { return inputObject(prev, "",  0, askExceeding); }
    public static Object inputObject(Object prev, String caption, boolean askExceeding) throws Exception { return inputObject(prev, caption, 0, askExceeding); }
    public static Object inputObject(Object prev, int tabs, boolean askExceeding) throws Exception { return inputObject(prev, "", tabs, askExceeding); }
    public static Object inputObject(Object prev, String caption, int tabs) throws Exception { return inputObject(prev, caption, tabs, false); }
    public static Object inputObject(Object prev, String caption, int tabs, boolean askExceeding) throws Exception {
        Field[] fs = prev.getClass().getDeclaredFields();
        String[] fields = new String[fs.length];
        for (int i=0; i<fs.length; i++) fields[i]=fs[i].getName();
        _inputObject(prev, caption, fields, fields, tabs, askExceeding);
        return prev;
    }
    public static Object inputObject(SelfInputable prev) throws Exception { return inputObject(prev, "",  0, false); }
    public static Object inputObject(SelfInputable prev, String caption) throws Exception { return inputObject(prev, caption, 0, false); }
    public static Object inputObject(SelfInputable prev, int tabs) throws Exception { return inputObject(prev, "", tabs, false); }
    public static Object inputObject(SelfInputable prev, boolean askExceeding) throws Exception { return inputObject(prev, "",  0, askExceeding); }
    public static Object inputObject(SelfInputable prev, String caption, boolean askExceeding) throws Exception { return inputObject(prev, caption, 0, askExceeding); }
    public static Object inputObject(SelfInputable prev, int tabs, boolean askExceeding) throws Exception { return inputObject(prev, "", tabs, askExceeding); }
    public static Object inputObject(SelfInputable prev, String caption, int tabs) throws Exception { return inputObject(prev, caption, tabs, false); }
    public static Object inputObject(SelfInputable prev, String caption, int tabs, boolean askExceeding) throws Exception {
        prev.input(caption, tabs, askExceeding);
        return prev;
    }
    public static Object inputObject(Inputable prev) throws Exception { return inputObject(prev, "",  0, false); }
    public static Object inputObject(Inputable prev, String caption) throws Exception { return inputObject(prev, caption, 0, false); }
    public static Object inputObject(Inputable prev, int tabs) throws Exception { return inputObject(prev, "", tabs, false); }
    public static Object inputObject(Inputable prev, boolean askExceeding) throws Exception { return inputObject(prev, "",  0, askExceeding); }
    public static Object inputObject(Inputable prev, String caption, boolean askExceeding) throws Exception { return inputObject(prev, caption, 0, askExceeding); }
    public static Object inputObject(Inputable prev, int tabs, boolean askExceeding) throws Exception { return inputObject(prev, "", tabs, askExceeding); }
    public static Object inputObject(Inputable prev, String caption, int tabs) throws Exception { return inputObject(prev, caption, tabs, false); }
    public static Object inputObject(Inputable prev, String caption, int tabs, boolean askExceeding) throws Exception {
        String[] fields = prev.getFields();
        String[] titles = prev.getFieldsTitle();
        _inputObject(prev, caption, titles, fields, tabs, askExceeding);
        return prev;
    }
    private static Object _inputObject(Object prev, String caption, String titles[], String[] fields, int tabs, boolean askExceeding) throws Exception {
        if (prev==null) throw new Exception("Error: You cannot pass non primitive type as null value.");
        if (fields.length!=titles.length) throw new Exception("Error: Incompatible size of Fields and Fields title.");
        Class c = prev.getClass();
        String tabsStr = "";
        if (caption.equals("")) caption = "<"+c.getSimpleName()+">";
        for (int i=0; i<tabs; i++) tabsStr+= "\t";
        System.out.println(tabsStr+"Input "+caption+" content =>: {");
        if (askExceeding) {
            if (Ops.inputBool(tabsStr+"Exceed this object # "+caption)==true) {
                System.out.println(tabsStr+"}");
                return null;
            }
        }
        for (int i=0; i<fields.length; i++) {
            Field f = c.getDeclaredField(fields[i]);
            String t = f.getType().getTypeName();
            try {
                if (f.getType().isEnum()) {
                    System.out.println("Enum input is not supported yet...");
                } else if (t.equals("int")) {
                    f.set(prev, 0);
                    f.set(prev, Ops.inputInt(titles[i], false, tabs + 1));
                } else if (t.equals("char")) {
                    f.set(prev, '\0');
                    f.set(prev, Ops.inputChar(titles[i], tabs + 1));
                } else if (t.equals("byte") || t.equals("java.lang.Byte")) {
                    f.set(prev, 0);
                    f.set(prev, Ops.inputByte(titles[i], false, tabs + 1));
                } else if (t.equals("short") || t.equals("java.lang.Short")) {
                    f.set(prev, 0);
                    f.set(prev, Ops.inputShort(titles[i], false, tabs + 1));
                } else if (t.equals("long") || t.equals("java.lang.Long")) {
                    f.set(prev, 0L);
                    f.set(prev, Ops.inputLong(titles[i], false, tabs + 1));
                } else if (t.equals("boolean") || t.equals("java.lang.Boolean")) {
                    f.set(prev, false);
                    f.set(prev, Ops.inputBool(titles[i], tabs + 1));
                } else if (t.equals("String") || t.equals("java.lang.String")) {
                    f.set(prev, "");
                    f.set(prev, Ops.inputString(titles[i], tabs + 1));
                } else if (t.equals("float") || t.equals("java.lang.Float")) {
                    f.set(prev, 0F);
                    f.set(prev, Ops.inputFloat(titles[i], false, tabs + 1));
                } else if (t.equals("double") || t.equals("java.lang.Double")) {
                    f.set(prev, 0D);
                    f.set(prev, Ops.inputDouble(titles[i], false, tabs + 1));
                } else if (t.equals("int[]") || t.equals("java.lang.Integer[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputIntArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("byte[]") || t.equals("java.lang.Byte[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputByteArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("short[]") || t.equals("java.lang.Short[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputShortArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("long[]") || t.equals("java.lang.Long[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputLongArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("boolean[]") || t.equals("java.lang.Boolean[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputBoolArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("String[]") || t.equals("java.lang.String[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputStringArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("float[]") || t.equals("java.lang.Float[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputFloatArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else if (t.equals("double[]") || t.equals("java.lang.Double[]")) {
                    f.set(prev, null);
                    f.set(prev, ArrayOps.inputFloatArray(Ops.inputInt("[" + titles[i] + "] array size", true, tabs + 1), titles[i], tabs + 1));
                } else {
                    f.set(prev, null);
                    Class c2 = Class.forName(t);
                    Object o = c2.getDeclaredConstructor(new Class[]{}).newInstance();
                    f.set(prev, o);
                    if (f.get(prev) instanceof SelfInputable) {
                        inputObject((SelfInputable) f.get(prev), titles[i], tabs + 1, true);
                    } else if (f.get(prev) instanceof Inputable) {
                        inputObject((Inputable) f.get(prev), titles[i], tabs + 1, true);
                    } else {
                        inputObject(f.get(prev), titles[i], tabs + 1, true);
                    }
                }
            } catch (IllegalAccessException e) {
                continue;
            }
        }
        System.out.println(tabsStr+"}");
        return prev;
    }
    // Print value
    public static void printVal(Object self) { printVal(self, "", 0); }
    public static void printVal(Object self, String caption) { printVal(self, caption, 0); }
    public static void printVal(Object self, int tabs) { printVal(self, "", tabs); }
    public static void printVal(Object self, String caption, int tabs) {
        // Check if the (self) object is valid
        if (self==null) return;
        // Check if the caption is valid
        if (caption==null || caption.equals("")) caption="<"+self.getClass().getSimpleName()+">";
        // Check the number of tabs
        if (tabs<=0) tabs=0;
        // Create tabs string
        String tabsStr = "";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        // Print the value
        System.out.println(tabsStr+caption+": "+self.toString());
    }
    // Print Object
    public static void printObject(Object self) { printObject(self, "", 0); }
    public static void printObject(Object self, String caption) { printObject(self, caption, 0); }
    public static void printObject(Object self, int tabs) { printObject(self, "", tabs); }
    public static void printObject(Object self, String caption, int tabs) {
        if (self==null) return;
        Field[] fields = self.getClass().getDeclaredFields();
        if (fields.length<=0) return;
        if (tabs<0) tabs=0;
        String tabsStr = "";
        String[][] basicTypes = {{"java.lang.String", "int", "double", "boolean", "float", "short", "long", "char", "byte"}};
        if (caption==null || caption.equals("")) caption="<"+self.getClass().getSimpleName()+">";
        for (int i=0; i<tabs; i++) tabsStr+="\t";
        String subLevel = tabsStr+"\t";
        System.out.println(tabsStr+caption+" content : {");
        for (int i=0; i<fields.length; i++) {
            try {
                if (Ops.getOption(basicTypes, fields[i].getType().getTypeName())==0) {
                    System.out.println(subLevel+fields[i].getName()+" : "+fields[i].get(self).toString());
                } else if (fields[i].getType().getTypeName().endsWith("[]")) {
                    ArrayOps.printArray(ArrayOps.objToArray(fields[i].get(self)) , fields[i].getName(), tabs+1);
                } else if (fields[i].getType().isEnum()) {
                    Ops.printVal(fields[i].get(self), fields[i].getName(), tabs+1);
                } else {
                    printObject(fields[i].get(self), fields[i].getName(), tabs+1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(tabsStr+"}");
    }
}
