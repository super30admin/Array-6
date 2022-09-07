class Main {
    // approch 1 consodilated sum of the
    // first transaction and second transaction
    public static int maxProfit(int[] prices) {
        // null case
        if (prices == null || prices.length == 0)
            return 0;
        // first buy at day 0
        int buy1 = prices[0];
        // sell at day 0
        int sell1 = prices[0] - buy1;
        // second buy at day 0 with profit from
        // previous buy
        int buy2 = prices[0] - sell1;
        // sell at day 0
        int sell2 = prices[0] - buy2;
        int n = prices.length;
        // repeat this process until and get maximum from it
        for (int i = 1; i < n; i++) {
            // repeat this process for all days
            // buy at minimum value
            buy1 = Math.min(buy1, prices[i]);
            // sell next at next maximum value
            sell1 = Math.max(sell1, prices[i] - buy1);
            // buy with profit from previous buy
            buy2 = Math.min(buy2, prices[i] - sell1);
            // sell at max
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        // at end we get our result at sell2
        return sell2;
    }
    public static void main(String[] args) {
        int[] prices = new int[] {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}