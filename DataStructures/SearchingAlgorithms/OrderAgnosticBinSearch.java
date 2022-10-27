public class OrderAgnosticBinSearch {
    public static void main(String[] args) {

        //Increasing order
        //int[] arr = {-18, -12, -4, 0, 2, 8, 9, 15, 16, 19, 22, 25, 35, 89};

        //Decreasing Order
        int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
        int target = 22;
        int ans = orderAgnosticBinSearch(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBinSearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}