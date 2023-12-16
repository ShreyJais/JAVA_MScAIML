import java.util.Scanner;
class Performance {
    int Marks[] = new int[60]; //an integer to store the marks of max 60 students.
    int Size;
    
    //constructor
    Performance(){
    }
    
    //insert marks into the array
    void readMarks(){
        Scanner input = new Scanner(System.in);
        System.out.print("Number of student's Marks to be inserterd:\t");
        Size = input.nextInt();
        if (Size<0){
            System.out.println("Invalid input");
            System.exit(1);
        }
        
        System.out.println("Enter Marks:");
        for (int i=0; i<Size ; i++) {
            this.Marks[i] = input.nextInt();
            if (this.Marks[i]<0 || this.Marks[i]>100){
                System.out.println("Invalid input");
                System.exit(1);
            }
        }
    }
    
    int highestMark(){
        int max=0;
        for (int i=0;  i<Size;i++ ){
            if(max<Marks[i]){
                max=Marks[i];
            }
        }
        return max;
    }
    
    int leastMark(){
        int min=100;
        for (int i=0;  i<Size;i++ ){
            if(min>Marks[i]){
                min=Marks[i];
            }
        }
        return min;
    }
    
    int getMode(){
        int mode=0;
        int count;
        int Maxfreq=1;
        for(int i=0; i<Size; i++){
            count=0;
            for (int j=0;j<Size ;j++){
              if(Marks[i]==Marks[j]){
                  count++;
              }
            }
            if (count>Maxfreq){
                Maxfreq=count;
                mode = Marks[i];
            }
        
        }
        System.out.println("Mode of the Marks:\t"+mode);
        return Maxfreq;
    }
    
    void display(){
        for(int i=0; i<Size; ++i){
            System.out.println("Mark of student "+ (i+1) +":\t"+ Marks[i]+"\n");
        }
        System.out.println("highest Mark:\t"+this.highestMark());
        System.out.println("least Mark:\t"+this.leastMark());
        System.out.println("ModeFreq of the Marks:\t"+this.getMode());
    }
    
    public static void main(String[] args) {
        Performance p1 = new Performance();
        p1.readMarks();
        p1.display();
    }
}



