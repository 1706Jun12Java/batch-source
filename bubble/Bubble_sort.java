package bubble;

public class Bubble_sort {  
	// declare the sorting method which returns nothing
    static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp = 0;
        //iterate through the elements of the array
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                	 // compare each consecutive element and swap places
                	 // if the previous one is smaller than the next
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
  
    }  
    public static void main(String[] args) {  
                int arr[] ={1,0,5,6,3,2,3,7,9,8,4};  
                 
                System.out.println("Array before bubble sort:");  
                for(int i=0; i < arr.length; i++){  
                        System.out.print(arr[i] + ", ");  
                }  
                System.out.println();  
                
                //call the sorting method from the class declaration providing
                //the arr argument
                bubbleSort(arr);  
                 
                System.out.println("Array after bubble sort:");  
                for(int i=0; i < arr.length; i++){  
                        System.out.print(arr[i] + ", ");  
                }  
   
        }  
}  