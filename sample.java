 class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max=0;
        for (int i=1;i<prices.length;i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return max;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        int minbuy1=Integer.MAX_VALUE, minbuy2=Integer.MAX_VALUE,maxprofit1 = Integer.MIN_VALUE, maxprofit2 =Integer.MIN_VALUE;
        for (int i=0;i<prices.length;i++) {
            minbuy1 = Math.min(minbuy1, prices[i]); // min
            maxprofit1 = Math.max(maxprofit1, prices[i] - minbuy1);

            minbuy2 = Math.min(minbuy2, prices[i]-maxprofit1);
            maxprofit2 = Math.max(maxprofit2, prices[i]-minbuy2);
        }
        return maxprofit2;
    }
}


class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] minbuy = new int[k];
        int[] maxprofit = new int[k];
        Arrays.fill(minbuy, Integer.MAX_VALUE);
        for (int i=0;i<prices.length;i++) {
            for(int j=0;j<k;j++) {
                if (j == 0) {
                    minbuy[j] = Math.min(minbuy[j], prices[i]);
                } else {
                    minbuy[j] = Math.min(minbuy[j], prices[i] - maxprofit[j-1]);
                }
                maxprofit[j] = Math.max(maxprofit[j], prices[i] - minbuy[j]);
            }
        }
        return maxprofit[k-1];
    }
}
