
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Main {
    public static int maxProfit(int[] prices) {
        // null case
        if (prices == null || prices.length == 0)
            return 0;
        // here I will check if we encouter min
        // that is smaller than current min
        // update the min and count the max value
        int min = prices[0];
        int max = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}