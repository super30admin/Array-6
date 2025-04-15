// TC: O(n)
// SC: O(1)
// Approach: Dynamic Programming

public class LC309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int i10 = 0, i11 = 0, i20 = 0;
        for(int i=n-1;i>=0;i--){
            int j1 = Math.max(prices[i] + i20, i11);
            int j0 = Math.max(i11 - prices[i], i10);
            i20 = i10;
            i10 = j0;
            i11 = j1;
        }
        return i10;
    }
}
