import java.util.Scanner;  // Import the Scanner class

class Person{
    String name;
    int age; 
    String address;    
    void read(){
        Scanner input = new Scanner(System.in);
        System.out.println("name:");
        this.name = input.nextLine();
        System.out.println("age:");
        this.age = input.nextInt();
        System.out.println("address:");
        this.address = input.nextLine();
    }
    void display(){
        System.out.println("name:\t"+this.name+"\nage:\t"+this.age+"\naddress\t"+this.address);
    }
}

public class Main1
{
	public static void main(String[] args) {
	    Person p1 = new Person();
	    p1.read();
	    p1.display();
	}
}
