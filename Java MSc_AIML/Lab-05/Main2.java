//Interface fields are public, static and final by default 

import java.util.Scanner;

interface WaterConservationSystem{
    int calculateTrappedWater(int[] blockHeights);
}
abstract class RainySeasonConservation implements WaterConservationSystem{
    //public int calculateTrappedWater(int[] blockHeights){};
}
class CityBlockConservation extends RainySeasonConservation{
    @Override
    public int calculateTrappedWater(int[] blockHeights){
        int size = blockHeights.length;
        int[] waterlevel = new int[size];
        int Total = 0;
        int left = blockHeights[0]; //first element
        int right = blockHeights[size-1]; //last element 
        for (int i = 1; i < size; i++) {
            if(left < blockHeights[i]){ //when water is traped
                left = blockHeights[i]; //new tall left building
            }
            waterlevel[i] = Math.min(left,right)-blockHeights[i]; //works when ther is no bulding greater than left or right // use devide and concour method
        }
        for (int i : waterlevel) {
            Total += i;
        }
        return Total;
    }
}
    
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the city block");
        int n = sc.nextInt();
        int[] blockHeights = new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter the height of the building - "+(i+1));
            int height = sc.nextInt();
            blockHeights[i] = height;
        }
        sc.close(); // Close the Scanner here

        System.out.println("The bulding in the city block is:");
    
        for (int i : blockHeights) {
           System.out.print(i+" ");
        }
        CityBlockConservation cityBlock = new CityBlockConservation();
        System.out.println("\nTotal trapped water:\t" + cityBlock.calculateTrappedWater(blockHeights)); 
    }
}
