package com.company;
class OuterClass {
    public int data1 = 1;
    public static int data2 = 2;

    static class InnerClass<T extends Comparable<T>> {
        public int data3;
        public static final int data4 = 10;
        public OuterClass out;
        public InnerClass() {

        }
        public InnerClass(OuterClass out) {
            this.out = out;
        }
        public InnerClass(int data3) {
            this.data3 = data3;
        }

        public void func() {
            System.out.println("innerclass");
            System.out.println(data3);
            System.out.println(out.data1);
            System.out.println(data2);
        }
        public T findMax(T[] arr) {
            T max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if(max.compareTo(arr[i]) < 0) {
                    max = arr[i];
                }
            }
            return max;
        }
    }
}
//abstract class OuterClass {
//    public abstract void sayHello();
//}
public class Main {

    public static void main(String[] args) {


        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        Integer[] arr = {3,4,2,1,5,6,8};
        System.out.println(inner.findMax(arr));
//        int data1 = 10;
//        new OuterClass() {
//            @Override
//            public void sayHello() {
//                System.out.println("hahhahahhhaha");
//                System.out.println(data1);
//            }
//        }.sayHello();
//        OuterClass out = new OuterClass();
//        out.sayHello();
//	    OuterClass out = new OuterClass();
//	    OuterClass.InnerClass inner = new OuterClass.InnerClass(out);
//	    inner.func();

    }
}
