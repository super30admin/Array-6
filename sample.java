//Problem 1: Buy and Sell Stock
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Only sell on increasing graphs
class Solution {
    public int maxProfit(int[] prices) {
        //O(n^2)
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length && prices[j]>prices[i];j++)
                profit= Math.max(profit, prices[j]-prices[i]);
        }
        return profit;
        
        //O(n)
        // int lowSellDay=0, largestDif=0; //assign lowest buy day to 0th loc
        // for(int i=1;i<prices.length;i++){
        //     if(prices[i]<prices[lowSellDay]) //if u find any location with less than lowest buy day, change lowestBuying day.
        //         lowSellDay=i;
        //     largestDif=Math.max(largestDif,prices[i]-prices[lowSellDay]); //calculate largest diff i.e profit
        // }
        // return largestDif;
    }
}

//Problem 2: Buy and Sell Stock |||
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// First buy and minimum index, then first sell at prices[i]-buy1. on this sell1 compute buy2 sell2
class Solution {
    public int maxProfit(int[] prices) {
        // if(prices==null|| prices.length==0) return 0;
        // int max=helper(prices, 0, prices.length-1);
        // for(int i=0;i<prices.length-1;i++){
        //     int profit1= helper(prices, 0, i);
        //     int profit2=helper(prices, i+1, prices.length-1);
        //     max=Math.max(max, profit1+profit2);
        // }
        // return max;

        //O(n) O(1)
        // int buy1=prices[0];
        // int sell1=0;
        // int buy2=prices[0];
        // int sell2=0;

        // for(int i=0;i<prices.length;i++){
        //     buy1=Math.min(buy1, prices[i]);
        //     sell1= Math.max(sell1, prices[i]-buy1);
        //     buy2= Math.min(buy2, prices[i]-sell1);
        //     sell2=Math.max(sell2, prices[i]-buy2);
        // }
        // return sell2;
    }

    private int helper(int[] prices, int low, int high){
        int min=prices[low], n=prices.length, max=Integer.MIN_VALUE;
        
        for(int i=low;i<=high;i++){
            min=Math.min(min, prices[i]);
            max=Math.max(max, prices[i]-min);
        }
        return max;
    }
}

//Problem 3: Buy and Sell Stock |V
// Time Complexity : O(nk)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
same as before just that we need a k loop for multiple transactions
class Solution {
    //O(nk) O(k+1)
    public int maxProfit(int k, int[] prices) {
        int[] buy=new int[k+1];
        int[] sell=new int[k+1];
        Arrays.fill(buy,Integer.MAX_VALUE);
        int n=prices.length;

        for(int i=0;i<n;i++){
            for(int j=1;j<=k;j++){
                buy[j]=Math.min(buy[j], prices[i]-sell[j-1]);
                sell[j]=Math.max(sell[j], prices[i]-buy[j]);
            }
        }
        return sell[k];
    }
}

//Problem 4: Buy and Sell Stock with Cooldown
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n<2 || prices==null) return 0;
        int[] dpbuy=new int[n];
        int[] dpsell=new int[n];

        dpbuy[0]= -prices[0];
        dpbuy[1]=Math.max(dpbuy[0],0-prices[1]);
        dpsell[1]=Math.max(0, dpbuy[0]+prices[1]);

        for(int i=2;i<prices.length;i++){
            dpbuy[i]=Math.max(dpbuy[i-1],dpsell[i-2]-prices[i]);
            dpsell[i]=Math.max(dpsell[i-1], dpbuy[i-1]+prices[i]);
        }

        return dpsell[n-1];
    }
}