import java.util.Scanner;

class Main{
    static int Size;
    static int arr[] = new int[100];	//we have limit to 100 elements storage
    static Scanner input = new Scanner (System.in);
    static void arrInput(){
        System.out.print ("Size of the arr in number:\t");
        Size = input.nextInt();
        if(Size < 0){
            System.out.println ("Invalid input");
            System.exit(1);
        }
        //else{static int arr[] = new int[Size];} //we can't declare static variable in any function or constructer
        
        for(int i = 0; i < Size; i++){
            System.out.print ("Enter numberical value for element " + i + ":\t");
            arr[i] = input.nextInt ();
            if(arr[i] < 0){
              System.out.println ("Invalid input");
              System.exit (1);
            }
        }
    }
    static void Mode(int K){
    	//sorting
     	for(int i = 0; i < Size-1; i++){
     	    for(int j = 0; j < Size-i-1; j++){
        	    if(arr[j]<arr[j+1]){
        	        //System.out.println("before i " + arr[i] + "j " + arr[j]);
        	        arr[j] ^= arr[j+1];
        	        arr[j+1] ^= arr[j];
        	        arr[j] ^= arr[j+1];
        	        //System.out.println("after i " + arr[i] + "j " + arr[j]);
        	    }
    	    }
        }
        for(int i=0; i<Size; ){
            System.out.print(i);
        }
        int count=0;
        for(int i; i<Size; i++){
            if(arr[i]==arr[i+1]){
                ++count;
                if(count>1){
                }
            }
            else{
                count=0;
            }
        }
    }
    public static void main(String[]args){
        arrInput();
    	System.out.print("Input for K:\t");
            int k = input.nextInt();
    	if(k<0){
                System.out.println("Invalid input");
                System.exit (1);
       	}
    	else{
    	    Mode(k);
    	}
    }
}
