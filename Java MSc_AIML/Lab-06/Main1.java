import java.util.Scanner;
public class Main1
{
    static int sum;
    static int result;
    static int[] coins;
    static int coin(int[] coins, int sum) {
        return count(coins, coins.length, sum);
    }
    static int count(int[] coins, int length , int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || coins.length <= 0) {
            return 0;
        }
        return count(coins, length, sum - coins[length - 1]) + count(coins, length - 1, sum);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a=0;
        Thread t1 = new Thread(()-> {
            System.out.println("N = ");
            int n = sc.nextInt();
            System.out.println("Sum = ");
            sum = sc.nextInt();
            coins=new int[n];
                for(int i=0;i<n;i++)
                {
                    System.out.println("coint "+(i+1)+" = ");
                    coins[i] = sc.nextInt();
                }
        });
        Thread t2 = new Thread(()-> {
            result = coin(coins,sum);
        });
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("There are " + result + " ways");
    }
}