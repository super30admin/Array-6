// approch 1 
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Main {

    // aproch 1 finding peak element and find profit
    public static int maxProfit1(int[] prices) {
        // null case
        if (prices == null || prices.length == 0)
            return 0;
        // go over loop and get min peak and
        // max peak element and calculate profit
        int result = 0;
        int i = 0;
        int n = prices.length;
        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int min = prices[i];
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int max = prices[i];
            result += max - min;
        }
        return result;
    }

    // aproch 2 finding max profit at each time
    public static int maxProfit2(int[] prices) {
        // null case
        if (prices == null || prices.length == 0)
            return 0;
        // go over loop and get if prices is less then
        // previous day sell right now and add it inside the result
        int result = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));

    }
}