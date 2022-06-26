// Time Complexity : O(n) where n is length of prices
// Space Complexity : O(1)

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let min = prices[0];
    let max = 0;
    for(let i = 1; i < prices.length; i++) {
        min = Math.min(min,prices[i]);
        max = Math.max(max,prices[i]-min);        
    }
    return max;
};