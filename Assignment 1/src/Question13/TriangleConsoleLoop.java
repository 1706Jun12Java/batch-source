package Question13;


public class TriangleConsoleLoop {

	public static void main(String args[]) {
		
		
	

			boolean flag=true;  
			
	int x=0;
			
			
		for( x=0; x<5; x++)
		{
			for(int y=x;y>0; y--){ 
				if(flag==true) {System.out.print("0");flag=false;} 
				else {System.out.print("1"); flag =true;}
			}
			System.out.println();
			
			
		}
	
}
	
	
	
	
}
