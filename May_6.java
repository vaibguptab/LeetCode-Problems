package May_Extras;

public class May_6 {
    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(tribonacci(3));

    }
    public static int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int tribonacci(int n) {
        if(n==0 || n==1) return n;
        if(n==2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
