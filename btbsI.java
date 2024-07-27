
class Solution {
    public int maxProfit(int[] prices) {
        // Tc: O(n) Sc: O(1)
        int ans = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;

        for (int i : prices) {
            buy = Math.min(buy, i);
            ans = Math.max(ans, i - buy);
        }
        return ans;
    }
}

// TLE Solution (Bruteforce )

/*
 * 
 * class Solution {
 * public int maxProfit(int[] prices) {
 * //Tc: O(n^2) Sc: O(1)
 * int n = prices.length;
 * int ans = Integer.MIN_VALUE;
 * for(int i = 0; i < n; i++)
 * {
 * for(int j = i; j < n; j++)
 * {
 * int buy = prices[i];
 * int sell = prices[j];
 * int profit = sell - buy;
 * ans = Math.max(ans, profit);
 * }
 * }
 * return ans;
 * }
 * }
 * 
 */

// Follow up solution to print the buy and sell prices as well their indexes

/*
 * class Solution {
 * public int maxProfit(int[] prices) {
 * int min = prices[0];
 * int max = 0;
 * int buy = 0;
 * int sell = 0;
 * int minInd = -1;
 * int maxInd = -1;
 * for(int i = 0; i < prices.length; i++)
 * {
 * //min = Math.min(min, prices[i]);
 * if(prices[i] < min)
 * {
 * min = prices[i];
 * minInd = i;
 * }
 * int curProfit = prices[i]-min;
 * if(max < curProfit)
 * {
 * buy = min;
 * sell = curProfit;
 * max = curProfit;
 * maxInd = i;
 * }
 * //System.out.println(min + max);
 * }
 * System.out.println(min);
 * System.out.println(max);
 * System.out.println(minInd);
 * System.out.println(maxInd);
 * return max;
 * }
 * }
 * 
 */