// my Python solution:
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        currMax = prices[len(prices)-1]
        maxDiff = 0
        for i in range(len(prices)-1, -1, -1):
            currMax = max(currMax, prices[i])
            maxDiff = max(maxDiff, currMax - prices[i])
        return maxDiff
        
// solution discussed in class:
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        
        for(int i=1; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i]-min);
        }
        return max;
    }
}
