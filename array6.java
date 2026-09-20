//problem1
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
}
//problem2
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy1=prices[0],buy2=prices[0];
        int sell1=0,sell2=0;
        for(int i=1;i<n;i++){
            buy1=Math.min(buy1,prices[i]);
            sell1=Math.max(sell1,prices[i]-buy1);
            buy2=Math.min(buy2,prices[i]-sell1);
            sell2=Math.max(sell2,prices[i]-buy2);
        }
        return sell2;
    }
}
//problem3
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[] buy=new int[k+1];
        int[] sell=new int[k+1];
        Arrays.fill(buy,prices[0]);
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }
}
//problem4
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1) return 0;
        int prevBuy = -prices[0];
        int prevSell = 0;
        int currBuy = Math.max(-prices[0], -prices[1]);
        int currSell = Math.max(prevSell, prevBuy + prices[1]);

        for(int i=2; i<n; i++){
            int tempBuy = currBuy, tempSell = currSell;

            currBuy = Math.max(currBuy, prevSell - prices[i]);
            currSell = Math.max(currSell, tempBuy + prices[i]);

            prevBuy = tempBuy;
            prevSell = tempSell;
        }
        return currSell;
    }
}
