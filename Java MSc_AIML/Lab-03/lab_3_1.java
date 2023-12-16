//Q1
public class lab_3_1{
    public static void main (String[] args) {
        SalariedEmployee e1 = new SalariedEmployee(01,"ram","Watchman",2500);
        e1.display();
        HourlyEmployee e2 = new HourlyEmployee(02,"ishika","Containt Writer",150,20);
        e2.display();
    }
}
class Employee
{
    int employeeId;
    String employeeName, designation;
    
    Employee(int ID, String Name, String designation){
        this.employeeId = ID;
        this.employeeName = Name;
        this.designation = designation;
    }
}

class HourlyEmployee extends Employee{
    double hourlyRate;
    int hoursWorked;
    HourlyEmployee(int ID, String Name, String designation, double hourlyRate, int hoursWorked){
        super(ID, Name, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    double weeklySalary(){
        return (this.hourlyRate*hoursWorked);
    }
    void display(){
        System.out.println("employeeId:\t"+this.employeeId+"\nemployeeName:\t"+this.employeeName+"\ndesignation:\t"+this.designation+"\nhourlyRate:\t"+this.hourlyRate+"\nhoursWorked:\t"+this.hoursWorked+"\nweeklySalary:\t"+weeklySalary());
    }
}

class SalariedEmployee extends Employee{
    double monthlySalary;
    SalariedEmployee(int ID, String Name, String designation, double monthlySalary){
        super(ID, Name, designation);
        this.monthlySalary = monthlySalary;
    }
    double weeklySalary(){
        return(this.monthlySalary/4);
    }
    void display(){
        System.out.println("employeeId:\t"+this.employeeId+"\nemployeeName:\t"+this.employeeName+"\ndesignation:\t"+this.designation+"\nmonthlySalary:\t"+this.monthlySalary+"\nweeklySalary:\t"+weeklySalary());
    }
}