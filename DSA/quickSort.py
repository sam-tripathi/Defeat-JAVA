def partition(arr, l, h):
    p = arr[h]

    i = l - 1

    for j in range(l, h):
        if arr[j] <= p:

            i = i + 1

            (arr[i], arr[j]) = (arr[j], arr[i])

    (arr[i + 1], arr[h]) = (arr[h], arr[i + 1])

    return i + 1
 
 
def quickSort(array, low, high):
    if low < high:

        pivot = partition(array, low, high)
 
        quickSort(array, low, pivot - 1)
 
        quickSort(array, pivot + 1, high)
 
 
arr = [10, 5, 20, 55, 40, 3]
 
n = len(arr)
 
quickSort(arr, 0, n - 1)
 
print(arr)

