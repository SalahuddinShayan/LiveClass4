package assistedPracticeProjects;

class KthSmallst 
{ 
    int kthSmallest(int arr[], int l, int r, int k) //array,0,6,4
    { 
        System.out.println("Inside KthSmallest");
        if (k > 0 && k <= r - l + 1) // 4>0 && 4<=(6-0+1)
        { 
            int pos = randomPartition(arr, l, r); 
            if (pos-l == k-1) 
                return arr[pos]; 
            if (pos-l > k-1) 
                return kthSmallest(arr, l, pos-1, k); 
            return kthSmallest(arr, pos+1, r, k-pos+l-1); 
        } 
        return Integer.MAX_VALUE; 
    } 
    void swap(int arr[], int i, int j) 
    { 
        System.out.println("Inside swap method");
        System.out.println("Value of arr[i] inside swap: "+arr[i]);
        System.out.println("Value of arr[j] inside swap: "+arr[j]);
        int temp = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
    } 

int partition(int arr[], int l, int r) //array,0,6
    { 
        System.out.println("inside partion method");
        int x = arr[r];
        System.out.println("Value of x inside partion method: "+x);
        int i = l; 
        System.out.println("Value of i inside partion method: "+i);
        for (int j = l; j <= r - 1; j++) 
        { 
            if (arr[j] <= x) 
            { 
                System.out.println("Inside if of partition");
                swap(arr, i, j); 
                i++; 
            } 
        } 
        swap(arr, i, r); 
        return i; 
    } 
    int randomPartition(int arr[], int l, int r) //array,0,6
    { 
        System.out.println("Inside randomPartition");
        int n = r-l+1; //6-0+1=7
        System.out.println("value of n inside randomPartition: "+n);
        int pivot = (int)(Math.random()) * (n-1); 
        System.out.println("value of pivot inside randomPartition: "+pivot);
        swap(arr, l + pivot, r); 
        return partition(arr, l, r); 
    } 
}  
public class KSmallest
{
    public static void main(String[] args) {
        KthSmallst ob = new KthSmallst(); 
        int arr[] = {12, 3, 5, 7, 4, 19, 26}; 
        int n = arr.length;
        int k = 4;
        System.out.println("K'th smallest element is "+ ob.kthSmallest(arr, 0, n-1, k)); 
    }
}