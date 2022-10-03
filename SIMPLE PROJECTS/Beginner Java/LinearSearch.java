//the key is at n+1 place, if found duplicate return its index, if not return -1

public class LinearSearch {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String a[]) {
        int[] f1 = { 230, 90, 309, 50, 760, 990 };
        int key = 170;
        System.out.println(key + " is at index number: " + linearSearch(f1, key));
    }
}
