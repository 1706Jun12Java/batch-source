package Question1;

public class BubbleSort {
    static void bubbleSort(int[] arr) {  
        int n = arr.length;  
        int temp;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){ 
                        	  //this is where the values switch
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }      
                 }  
         }  
    }  
    public static void main(String[] args) {  
                int[] arr ={1,0,5,6,3,2,3,7,9,8,4};  

                bubbleSort(arr);  
                 
                System.out.println("Bubble Sort");  
                for(int i=0; i < arr.length; i++){  
                        System.out.print(arr[i] + " ");  
                }  
   
        }  

}
