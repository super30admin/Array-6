# Array-6

## Problem1: Buy and Sell Stock at Best Time (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
public int maxProfit(int[] prices) {
if(prices == null || prices.length == 0) {
return 0;
}
int profit=0;
int min=Integer.MAX_VALUE;
for(int i = 0;i < prices.length; i++) {
min = Math.min(min, prices[i]);
profit = Math.max(profit, prices[i] - min);
}
return profit;
}
}

// Buy and Sell Stocks - ii

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
public int maxProfit(int[] prices) {
if(prices == null || prices.length == 0) {
return 0;
}
int profit = 0;

        for(int i = 0 ; i < prices.length - 1; i++) {
            int difference = prices[i+1] - prices[i];
            if(difference > 0) {
                profit += difference;
            }
        }
        return profit;
    }

}

## Problem2: Buy and Sell Stock at Best Time III (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)

// Time Complexity - O(N)
// Space Complexity - O(1)

class Solution {
public int maxProfit(int[] prices) {
if(prices == null || prices.length == 0) {
return 0;
}
int buy1 = Integer.MAX_VALUE;
int sell1 = 0;
int buy2 = Integer.MAX_VALUE;
int sell2 = 0;

        for(int i = 0 ; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }

}

## Problem3: Buy and Sell Stock at Best Time IV (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

// Time Complexity - O(Nk)
// Space Complexity - O(k)

class Solution {
public int maxProfit(int k, int[] prices) {
if(prices == null || prices.length == 0) {
return 0;
}

        int[] buy = new int[k+1];
        int[] sell = new int[k+1];

        Arrays.fill(buy, Integer.MAX_VALUE);

        for(int i = 0 ; i < prices.length; i++) {
            for(int j = 1; j <= k; j++) {
                buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }
        return sell[k];
    }

}

## Problem4: Buy and Sell Stock with cooldown https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

// Not yet taught in class will update once taught
