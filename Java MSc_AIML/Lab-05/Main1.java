//Interface fields are public, static and final by default 
//so is there any way to make the acess specifier to default ?
//and will it have any application?
//each time i have to add public specifier when declaring the method in the class!!
//hence Interface directly goes to compiler 
interface BankInterface{
    abstract double getBalance();
    abstract double getInterestRate();
    abstract void Deposit(double money);
}

class Bank implements BankInterface{
    double balance;
    double interest;
    //constructor
    Bank(double balance, double interest){
        this.balance = balance;
        this.interest = interest;
        System.err.println("your opning balance is:\t"+this.getBalance());
    }
    public void Deposit(double money){
        this.balance += money;
        System.err.println("Deposited amount:\t"+money);
        System.err.println("your curent balance is:"+this.getBalance());
    }
    public double getBalance(){
        return this.balance;
    }
    public double getInterestRate(){
        return this.interest;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Bank BankA = new Bank(10000,7); 
        Bank BankB = new Bank(150000,7.4); 
        Bank BankC = new Bank(200000,7.9); 
        System.out.println("Your BankA interest rate is:\t"+BankA.getInterestRate()+"%");
        System.out.println("Your BankB interest rate is:\t"+BankB.getInterestRate()+"%");
        System.out.println("Your BankC interest rate is:\t"+BankC.getInterestRate()+"%");
    }    
}