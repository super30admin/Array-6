public class BuyAndSell4 {
    public static int maxProfit4(int k, int[] prices){
        int n = prices.length;
        if( n ==0 || k ==0) return 0;

        if( k >= n/2) { // we have unlimited transactions
            int maxProfit = 0;
            for( int i =1; i < n; i++){
                if( prices[i] > prices[i -1]){
                    maxProfit+= prices[i] - prices[i-1];
                }
            }
            return maxProfit;
        }

        int[] buy = new int [k +1];
        int [] profit = new int [k +1];

        for( int i =0; i <=k ;i++){
            buy[i] = Integer.MAX_VALUE;
        }

        for(int price: prices){
            for( int i =1; i <=k; i ++){
                buy[i] = Math.min(buy[i], price- profit[i -1]);
                profit[i] = Math.max(profit[i], price - buy[i]);
            }
        }

        return profit[k];
    }

    public static void main( String[] args){
        BuyAndSell4 solution = new BuyAndSell4();
        int [] prices = {3,2,6,5,0,3};
        int k = 2;

        int result = maxProfit4(k, prices);

        System.out.println(result);

    }

}
