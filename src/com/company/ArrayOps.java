package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayOps {
    public static Scanner stdin = new Scanner(System.in);
    static <T> T[] objToArray(Object array) {
        Class ofArray = array.getClass().getComponentType();
        if (ofArray.isPrimitive()) {
            List ar = new ArrayList();
            int length = Array.getLength(array);
            for (int i = 0; i < length; i++) {
                ar.add(Array.get(array, i));
            }
            return (T[])ar.toArray();
        }
        else {
            return (T[]) array;
        }
    }
    // Input Int Array
    public static int[] inputIntArray(int size) { return inputIntArray(size, "", 0); }
    public static int[] inputIntArray(int size, String caption) { return inputIntArray(size, caption, 0); }
    public static int[] inputIntArray(int size, int tabs) { return inputIntArray(size, "", tabs); }
    public static int[] inputIntArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        int[] ret = new int[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[Int]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputInt("<int>["+i+"]", false, tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Input Byte Array
    public static byte[] inputByteArray(int size) { return inputByteArray(size, "", 0); }
    public static byte[] inputByteArray(int size, String caption) { return inputByteArray(size, caption, 0); }
    public static byte[] inputByteArray(int size, int tabs) { return inputByteArray(size, "", tabs); }
    public static byte[] inputByteArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        byte[] ret = new byte[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[Byte]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputByte("<byte>["+i+"]", false, tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Input Short Array
    public static short[] inputShortArray(int size) { return inputShortArray(size, "", 0); }
    public static short[] inputShortArray(int size, String caption) { return inputShortArray(size, caption, 0); }
    public static short[] inputShortArray(int size, int tabs) { return inputShortArray(size, "", tabs); }
    public static short[] inputShortArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        short[] ret = new short[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[Short]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputShort("<short>["+i+"]", false, tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Input Long Array
    public static long[] inputLongArray(int size) { return inputLongArray(size, "", 0); }
    public static long[] inputLongArray(int size, String caption) { return inputLongArray(size, caption, 0); }
    public static long[] inputLongArray(int size, int tabs) { return inputLongArray(size, "", tabs); }
    public static long[] inputLongArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        long[] ret = new long[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[Long]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputByte("<long>["+i+"]", false, tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Input Boolean Array
    public static boolean[] inputBoolArray(int size) { return inputBoolArray(size, "", 0); }
    public static boolean[] inputBoolArray(int size, String caption) { return inputBoolArray(size, caption, 0); }
    public static boolean[] inputBoolArray(int size, int tabs) { return inputBoolArray(size, "", tabs); }
    public static boolean[] inputBoolArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        boolean[] ret = new boolean[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[Boolean]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputBool("<boolean>["+i+"]", tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Input String Array
    public static String[] inputStringArray(int size) { return inputStringArray(size, "", 0); }
    public static String[] inputStringArray(int size, String caption) { return inputStringArray(size, caption, 0); }
    public static String[] inputStringArray(int size, int tabs) { return inputStringArray(size, "", tabs); }
    public static String[] inputStringArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        String[] ret = new String[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[String]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputString("<str>["+i+"]", tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Input Char array
    public static char[] inputCharArray(int size) { return inputCharArray(size, "", 0); }
    public static char[] inputCharArray(int size, String caption) { return inputCharArray(size, caption, 0); }
    public static char[] inputCharArray(int size, int tabs) { return inputCharArray(size, "", tabs); }
    public static char[] inputCharArray(int size, String caption, int tabs) {
        String str = Ops.inputString(caption, tabs);
        char[] ret = new char[str.length()];
        try {
            int i = 0;
            while (true) {
                ret[i] = str.charAt(i);
                i++;
            }
        } catch (IndexOutOfBoundsException e) {}
        return ret;
    }
    // Input Float Array
    public static float[] inputFloatArray(int size) { return inputFloatArray(size, "", 0); }
    public static float[] inputFloatArray(int size, String caption) { return inputFloatArray(size, caption, 0); }
    public static float[] inputFloatArray(int size, int tabs) { return inputFloatArray(size, "", tabs); }
    public static float[] inputFloatArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        float[] ret = new float[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[Float]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputFloat("<float>["+i+"]", false, tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Input Double Array
    public static double[] inputDoubleArray(int size) { return inputDoubleArray(size, "", 0); }
    public static double[] inputDoubleArray(int size, String caption) { return inputDoubleArray(size, caption, 0); }
    public static double[] inputDoubleArray(int size, int tabs) { return inputDoubleArray(size, "", tabs); }
    public static double[] inputDoubleArray(int size, String caption, int tabs) {
        if (size<0) {
            System.out.println("Error: Minus value is not accepted as size.");
            return null;
        }
        double[] ret = new double[size];
        if (tabs<0) tabs = 0;
        String tabsStr = "";
        if (caption.equals("")) caption="[Double]";
        for (int i=0; i<tabs; i++) tabsStr += "\t";
        System.out.println(tabsStr+"Input "+caption+" Array =>: {");
        for (int i=0; i<size;i++) {
            ret[i] = Ops.inputDouble("<double>["+i+"]", false, tabs+1);
        }
        System.out.println(tabsStr+"}");
        return ret;
    }
    // Print Array
    public static <T> void printArray(T[] arr) { printArray(arr, "", 0); }
    public static <T> void printArray(T[] arr, String caption) { printArray(arr, caption, 0); }
    public static <T> void printArray(T[] arr, int level) { printArray(arr, "", level); }
    public static <T> void printArray(T[] arr, String caption, int level) {
        if (arr==null || arr.length==0) {
            System.out.println("Error: Empty array passed.");
            return;
        }
        String[][] basicTypes = {{"java.lang.String", "java.lang.Integer", "Java.lang.Double", "java.lang.Boolean", "Java.lang.Float", "java.lang.Short", "java.lang.Long", "java.lang.Character", "java.lang.Byte"}};
        String tabsStr = "";
        for (int i=0; i<level; i++) tabsStr += "\t";
        String subLevel = tabsStr+"\t";
        if (caption.equals("")) caption = "<Array>";
        System.out.println(tabsStr+caption+" array : {");
        for (int i=0; i<arr.length; i++) {
            if (Ops.getOption(basicTypes, arr[i].getClass().getTypeName())==0) {
                System.out.println(subLevel+"[" + i + "]" + arr[i].toString());
            } else if (arr[i].getClass().getTypeName().endsWith("[]")) {
                printArray(objToArray(arr[i]) , "["+i+"]", level+1);
            } else {
                Ops.printObject(arr[i], "", level+1);
            }
        }
        System.out.println(tabsStr+"}");
    }
    public static void main(String[] args) {

    }
}

