// Time Complexity : O(n) where n is length of prices
// Space Complexity : O(1)

/**
 * @param {number[]} prices
 * @return {number}
 */
 var maxProfit = function(prices) {
    let buy1 = Infinity, buy2 = Infinity, sell1 = 0, sell2 = 0;
    for(let i = 0; i < prices.length; i++) {
        buy1 = Math.min(buy1, prices[i]);
        sell1 = Math.max(sell1, prices[i] - buy1);
        buy2 = Math.min(buy2, prices[i] - sell1);
        sell2 = Math.max(sell2, prices[i] - buy2);
    }
    return sell2;
};