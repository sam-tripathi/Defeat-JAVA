public class binarySearch {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int key=4;
        System.out.println(binaryS(arr,key));
    }
    static int binaryS(int[] arr,int key){
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==key){
                return mid;
            }
            if(arr[mid]>key){
                end=mid-1;
            }
            if (arr[mid]<key){
                start=mid+1;
            }
            }
        return -1;

        }
    
}
