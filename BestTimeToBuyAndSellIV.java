import java.util.Arrays;
/*
Time Complexity: O(nk), n is the length of prices array and k is the given number of transactions
Space Complexity: O(k), minPrices and maxProfit array
Run on leetcode: yes
Any difficulties: no

Approach:
1. Generalizing solution for two transaction for the k most transactions
 */
public class BestTimeToBuyAndSellIV {
    public static int maxProfitAtMostKTransactions(int[] prices, int k){
        if(k == 0){
            return 0;
        }

        int[] minPrices = new int[k];
        int[] maxProfit = new int[k];

        Arrays.fill(minPrices, Integer.MAX_VALUE);

        for(int price: prices){
            for(int i = 0; i<k; i++){
                if( i == 0){
                    minPrices[i] = Math.min(minPrices[i], price);
                }else{
                    minPrices[i] = Math.min(minPrices[i], price-maxProfit[i-1]);
                }

                maxProfit[i] = Math.max(maxProfit[i], price-minPrices[i]);
            }
        }
        return maxProfit[k-1];
    }

    public static void main(String[] args){
        System.out.println("K most Transactions, maximum profit: "+ maxProfitAtMostKTransactions(new int[]{2,4,1}, 2));
    }
}
