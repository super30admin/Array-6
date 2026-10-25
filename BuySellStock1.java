/**
 * Time Complexity:  O(n)  where n is the length of the array
 * Space Complexity: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for(int i=0; i<prices.length-1; i++){
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i+1] - min);
        }

        return result;

    }
}