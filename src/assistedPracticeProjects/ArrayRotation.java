package assistedPracticeProjects;

class RotateArray { 
    public void rotate(int[] nums, int k) { //nums=array  &  k=no: of positions
        System.out.println("Value of k:"+k);
        System.out.println("Value of array length:"+nums.length);
        if(k > nums.length)// 5>7 
        {
            System.out.println("Inside if condition");
            k=k%nums.length;
        }
        int[] result = new int[nums.length];//an array having length same as the original array
        for(int i=0; i < k; i++){
            System.out.println("Value from for loop for iteration "+i+" is: "+(nums.length-k+i));
            result[i] = nums[nums.length-k+i];
        }
        System.out.println("Value inside result");
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+", ");
        }
        System.out.println();
        int j=0;
        for(int i=k; i<nums.length; i++)//5<7
        {
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, nums.length );
    }
} 


public class ArrayRotation
{
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
        r.rotate(arr, 5); //array,no: of rotations
        System.out.println("--------------------");
        System.out.println("the end result is :");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}