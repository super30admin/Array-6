//TC: O(n)
//sc: O(1)

//approach: finding the least before the greatest value in the arrays

class Solution {
    public int maxProfit(int[] prices) {
        int max =0;
        int len = prices.length;
        //brute force: O(n^2)  TLE
        
        // for(int i=0;i<len;i++){
        //     for(int j=i+1;j<len;j++){
        //         if(prices[i]<prices[j]){
        //             max = Math.max(max,prices[j]-prices[i]);
        //         }
        //     }
        // }
        //   return max;   
        
        int min = Integer.MAX_VALUE;
        int profit =0;
        for(int i=0;i<len;i++){
            if(prices[i]<min)
                min = prices[i];
            if(prices[i]-min > profit)
                profit = prices[i]-min;
        }
        return profit;
    }
}