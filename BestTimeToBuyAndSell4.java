class Solution {

    //Time Complexity: o(nk) where n is the elements in the prices array and k is the no. of transactions I can perform
    //Space Complexity: 0(k)

    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices == null || prices.length == 0){
            return 0;
        }

        int [] buy = new int[k];    //I take an array in this case because i can have k no. of transactions. So I take an array of size k which acts as no. of variables in other cases and then calculate my buy and sell at every idex
        Arrays.fill(buy, Integer.MAX_VALUE);
        int [] sell = new int[k];   //same with sell, I take an array of size k as I will need to take variables as no. of transactions I can perform which is unknown. So I just take an array of length k

        for(int i = 0; i < prices.length; i++){//to go over every prices
            for(int j = 0; j < k; j++){ //I have to compute buy1, sell1, buy2, sell2, buy3, sell3, buy4, sell4 for 4 transactions. Basically I have to go over all the buy and sell for the no. of transaction
                if(j > 0){
                    buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);   //I buy at min price also, I reinvest my prev profit into my new buy which is goven by prices[i] - sell[j-1]
                }
                else{   //if j is 0, then I will have index out of bounds
                    buy[j] = Math.min(buy[j], prices[i]);
                }
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);    //calculating sell by my normal formula
            }
        }

        return sell[k-1];   //the asnwer will lie at the last index
    }
}

