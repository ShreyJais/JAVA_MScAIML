abstract class Robber{
    abstract int RowHouses(int[] money);
    //abstract int RoundHouses(int[] money);
    //abstract int SquareHouse(int[] money);
    //abstract int MultiHouseBuilding(int[] money);
    void RobbingClass(){
        System.out.println("MScAI&ML");
    } 
    void MachineLearning() {
        System.out.println("I love MachineLearning.");
    }
}

class JAVAProfessionalRobber extends Robber {
    int RowHouses(int[] money) {
        int arrLength = money.length;
        if (arrLength == 0) {
            System.out.println("No houses to rob.");
        }
        else if(arrLength == 1){
            return money[0];
        }
        else if(arrLength == 2){
            return Math.max(money[0], money[1]);
        }
        else{
            int evenHouses = 0, oddHouses = 0; //for alternate houses to rob as we can't rob adjacent houses
            for (int i = 0; i < money.length; i++) {
                if (i % 2 == 0) {   //if even(0,2,4,...)
                    evenHouses += money[i];
                } else {    //if odd(1,3,5,...)
                    oddHouses += money[i];
                }
            }
            return Math.max(evenHouses, oddHouses);   //Max amount of money we can rob
        }
        return -1;
    }
/* 
    @Override
    int RoundHouses(int[] money) {
        if (money.length == 0) {
            System.out.println("No houses to rob.");
            System.exit(1);
        }
        if (money.length == 1) {
            return money[0];
        }
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(money[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[money.length - 1];
    }
    */
}

public class Main {
    public static void main(String[] args) {
        JAVAProfessionalRobber ob1 = new JAVAProfessionalRobber();
        int[] money = { 1, 2, 3, 4, 5, 6};
        System.out.println(ob1.RowHouses(money));
    }
}