package generice;


class Alo <T extends Comparable<T>> {
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

class Alo2 {
    public static<T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max.compareTo(arr[i]) < 0) {
                max = arr[i];
            }
        }
        return max;
    }

}
public class TestDemo {
    public static void main(String[] args) {
        Alo<Integer> alo = new Alo<>();
        Integer[] arr = {3,4,2,1,5,6,8};
        Integer max = alo.findMax(arr);
        System.out.println(max);
        System.out.println(Alo2.findMax(arr));
    }
}
