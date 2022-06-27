// Time Complexity : O(nk) where n is length of prices
// Space Complexity : O(k)

/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(k, prices) {
    let buy = new Array(k+1).fill(Infinity);
    let sell = new Array(k+1).fill(0);
    for(let i = 0; i < prices.length; i++) {
        for(let j = 1; j <= k; j++) {
            buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
            sell[j] = Math.max(sell[j], prices[i] - buy[j]);
        }
    }
    return sell[k]
};