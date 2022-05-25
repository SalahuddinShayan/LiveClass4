package assistedPracticeProjects;

public class RangeQueries {  static int k = 16;
static int N = 100000; 
static long table[][] = new long[N][k + 1]; 
static void buildSparseTable(int arr[], int n) //array,6
{ 
    System.out.println("Inside buildSparseTable method");
    for (int i = 0; i < n; i++) 
        table[i][0] = arr[i]; 
    for (int j = 1; j <= k; j++) 
        
        for (int i = 0; i <= n - (1 << j); i++) {
            table[i][j] = table[i][j - 1] + table[i + (1 << (j - 1))][j - 1]; 
            System.out.println("Value of table["+i+"]["+j+"] is : "+table[i][j]);
        }
} 
static long query(int L, int R) 
{
    System.out.println("Inside query method");
    long answer = 0; 
    for (int j = k; j >= 0; j--)  
    { 
        System.out.println("The value of j inside the query method: "+j);
        if (L + (1 << j) - 1 <= R)  
        { 
            System.out.println("Inside if condition of query method");
            
            answer = answer + table[L][j];
            System.out.println("The value inside table[i][j] is: "+table[L][j]);
            System.out.println("The value of answer is: "+answer);
            L += 1 << j; 
            System.out.println("The value of L inside the if conditio of the query method: "+L);
            
        } 
    } 
    return answer; 
}
public static void main(String args[]) 
{ 
    int arr[] = { 3, 7, 2, 5, 8, 9 }; 
    int n = arr.length;//6 
    buildSparseTable(arr, n); 
    System.out.println(query(0, 5)); 
    System.out.println(query(3, 5)); 
    System.out.println(query(2, 4)); 
} 
}