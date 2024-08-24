package Array-6;
// TC: O(N)
// SC: O(1)
public class Problem4 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1) return 0;
        
        int prevBuy = -prices[0];
        int prevSell = 0;

        int currBuy = Math.max(-prices[0],-prices[1]);
        int currSell = Math.max(prevSell, prevBuy+prices[1]);

        for(int i=2;i<n;i++){
            int temp = currSell;
            currBuy = Math.max(currBuy,prevSell-prices[i]);
            currSell = Math.max(currSell, currBuy+prices[i]);
            prevSell = temp;
        }

        return currSell;
    }
}
