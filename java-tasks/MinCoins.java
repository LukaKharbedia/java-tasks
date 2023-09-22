public class MinCoins {
    public static int minSplit(int amount) {
        int[] coins = {1, 5, 10, 20, 50};
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        int amount = 570;
        int result = minSplit(amount);
        System.out.println("Minimum number of coins to make " + amount + " tetri: " + result);
    }
}
