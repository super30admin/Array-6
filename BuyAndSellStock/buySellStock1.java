public int maxProfit(int[] prices) {

    int min = Integer.MAX_VALUE;
    int max = 0;

    for(int p:prices) {
        min = Math.min(min, p);
        max = Math.max(p-min, max);
    }

    return max;
}




Best Time to Buy and Sell Stock III


public class Solution {
public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) {
        return 0;
    }
    return constantSpaceDP(prices);
    //return nSpaceDP(prices);
    //return mnSpaceDP(prices);
}

/*
sell2[i]: max profit when have sold upon p[i], total transaction is 2
buy2[i]: max profit when have bought upon p[i], total transaction is 2
sell1[i]: max profit when have sold upon p[i], total transaction is 1
buy1[i]: max profit when have bought upon p[i], total transaction is 1

sell2[i] = max(sell2[i - 1], buy2[i - 1] + p[i])
buy2[i] = max(buy2[i - 1], sell1[i - 1] - p[i])， buy2 depends on previous sell1

sell1[i] = max(sell1[i - 1], buy1[i - 1] + p[i])
buy1[i] = max(buy1[i - 1], -p[i])

optimization: space O(4n) -> O(4)
*/   

private int constantSpaceDP(int[] p) {
    int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
    for (int tp : p) {
        sell2 = Math.max(sell2, buy2 + tp);
        buy2 = Math.max(buy2, sell1 - tp);
        sell1 = Math.max(sell1, buy1 + tp);
        buy1 = Math.max(buy1, -tp);
    }
    return Math.max(sell1, sell2);
}

/*
M[i][j]: max profit of i-th transaction from day 0 to day j
M[i][j] = max(M[i][j - 1], max(M[i - 1][k] + p[j] - p[k])), k from 0 to j - 1
        = max(M[i][j - 1], p[j] + max(M[i - 1][k] - p[k]))
        = max(M[i][j - 1], p[j] + tmp);
    tmp = Math.max(tmp, M[i - 1][j] - p[j]);
optimization: space O(m*n) -> O(n)
*/

private int nSpaceDP(int[] p) {
    int[] M = new int[p.length];
    for (int i = 1; i < 3; i++) {
        int tmp = M[0] - p[0], top;
        for (int j = 1; j < p.length; j++) {
            top = M[j];
            M[j] = Math.max(M[j - 1], tmp + p[j]);
            tmp = Math.max(tmp, top - p[j]);
        }
    }
    return M[p.length - 1];
}

private int mnSpaceDP(int[] p) {
    int[][] M = new int[3][p.length];
    for (int i = 1; i < 3; i++) {
        int tmp = M[i - 1][0] - p[0];
        for (int j = 1; j < p.length; j++) {
            M[i][j] = Math.max(M[i][j - 1], tmp + p[j]);
            tmp = Math.max(tmp, M[i - 1][j] - p[j]);
        }
    }
    return M[2][p.length - 1];
}
}




Best Time to Buy and Sell Stock IV

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        
        int[] buy = new int[k]; // buy[i]: min cost at (i + 1)-th time stock purchased
        int[] sell = new int[k]; // sell[i]: max revenue at (i + 1)-th time stock sold
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        
        for (int i : prices) {
            buy[0] = Math.max(buy[0], i * -1);
            sell[0] = Math.max(sell[0], buy[0] + i);
            for (int j = 1; j < k; j++) { // The i-th time buy & sell depens on the (i - 1)-th time buy & sell
                buy[j] = Math.max(buy[j], sell[j - 1] - i);
                sell[j] = Math.max(sell[j], buy[j] + i);
            }
        }
        return sell[k - 1];
    }
}





Best Time to Buy and Sell Stock with Cooldown
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int n = prices.length, max;
        int[] sell = new int[n];
        int[] rest = new int[n];
        
        sell[0] = 0;
        sell[1] = Math.max(prices[1] - prices[0], 0);
        for(int i = 2; i < sell.length; i++){            
            int profit = prices[i]-prices[i-1];
            sell[i] = Math.max(Math.max( sell[i-1], rest[i-2] ) + profit, 0);
            rest[i] = Math.max(sell[i-1], rest[i-1]);
        }
        return  Math.max(sell[n-1], rest[n-1]);
    }
}

Time complexity: O(N)



