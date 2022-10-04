# Searching Algorithms in JAVA  

First of all what are `searching algorithms`?

We use searching algorithms in different programming languages to search an element or to retrieve it from any data structure in which it is stored at a particular memory location.  

There are two types of searching algorithm in java:

### Linear Search

This is the iterative searching technique. 

### Binary Search

This is the interval searching technique.

## Linear Search

The idea in `Linear searching` is to iterate the whole data structure and if the desired element is found then we break out.

Let's say we are using an array data structure (arr[]). So, to linear search an element X the following algo has to be implemented.

### Linear Search Algorithm

* We will start our search for the element X from the leftmost position in the array. This we will do with the help of a for loop.
* One by one we will compare X with each element of arr[] until we reach the end of for loop.
* If the element X matches with an element of the array then we will return the index at which match has occured.
* If X doesn’t match with any of elements and we reach the end then we will return -1 which signifies that the element is not found.

### Implementation

```JAVA
class LinearSearch {
 
    // Function for linear search
    public static int linearsearch(int arr[], int X)
    {
        int len = arr.length;
 
        // Traverse array arr[]
        // 0 based indexing is followed
        for (int i = 0; i < len; i++) {
 
            // If element found then we will return that index at which it is found
            if (arr[i] == X)
                return i;
        }
        return -1;
    }
 
    public static void main(String args[])
    {
        // Given arr[]
        int arr[] = { 10, 20, 30, 40, 50};
 
        // Let the Element to search
        int X = 30;
 
        // Function Call for Linear Search
        int found = linearsearch(arr, X);
        if (found == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at " + "index: " + found);
    }
}
```

### Input

10 20 30 40 50

X = 30

### Output

Element found at index: 2

### Time Complexity

Since, we are just traversing the array of length len once. So, the worst case time complexity will be $O(N)$. And the best case time complexity will be $O(N)$ i.e. the element is found at first position.

### Space Complexity

Since, no extra space is used therefore the space complexity will be $O(1)$

---

## Binary Search

Binary Search algorithm is always applied in `sorted array` or any other data structure. In this technique we start by taking the whole array and in each step we divide the searching interval in half.

In each division we take out the middle element and check if the value of the search key (X) is less than the middle element, then we narrow the interval to the lower half. Otherwise we narrow it to the upper half. We do it repeatedly until the value is found or the interval is empty. 

### Binary Search Algorithm

* Compare Search key (X) with the middle element of the searching interval.
* If X matches with middle element, we return the mid index. This is the index at which our search key is present.
* Else If X is greater than the mid element, then X can only lie in the right half subarray after the mid element. So we check for the search key in the right half i.e. after the middle element.
* Else (X is smaller) we search in the left half.

### Implementation

```JAVA
class BinarySearch {
 
    // Function that returns index of X if it is present in arr[l, r], l and r are the index of the start and end position of the search interval
    int binarysearch(int arr[], int l, int r, int X)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at the middle itself we return that index
            if (arr[mid] == X)
                return mid;
 
            // If element is smaller than mid, then it can only be present in left side array, because the array is sorted.
            if (arr[mid] > X)
                return binarysearch(arr, l, mid - 1, X);
 
            // Else the element can only be present in right side array
            return binarysearch(arr, mid + 1, r, X);
        }
 
        // If the element is not present in the array
        return -1;
    }
 
    public static void main(String args[])
    {
 
        BinarySearch ob = new BinarySearch();
 
        //Let array arr[]
        int arr[] = { 10, 20, 30, 40, 50};
        int len = arr.length;
        
        //Search Key
        int X = 30;
 
        // Function Call
        int found = ob.binarysearch(arr, 0, len - 1, X);
 
        if (found == -1)
            System.out.println("Element "+ "not found");
        else
            System.out.println("Element found at "+ "index: " + found);
    }
}
```

### Input

10 20 30 40 50

X = 30

### Output

Element found at index: 2

### Time Complexity

As each time we divide the searching interval in half and we are doing the searching recursively. Hence, the time complexity is $O(NlogN)$. 

### Space Complexity

Since no extra space is used except variables. So, the space complexity is $O(1)$

---

* Some Leetcode problem Links for practice

| Problem Title    | Difficulty |
| ---------------- | ---------- | 
| [704 - Binary Search](https://leetcode.com/problems/binary-search/) | Easy   |
| [35 - Search Insert Position](https://leetcode.com/problems/search-insert-position/) | Easy |
| [33 - Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | Medium |
| [4 - Median of two sorted arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Hard |


* For more problems follow this link: [Searching Problems](https://leetcode.com/tag/binary-search/)

# Author

- [@wizeewig](https://www.github.com/wizeewig)
