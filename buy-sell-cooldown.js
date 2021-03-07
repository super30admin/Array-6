// Time, Space - O(N), O(N)

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    
    if(prices === null || prices.length < 2) {
        return 0;
    }
    let buy = new Array(prices.length);
    let sell = new Array(prices.length);    
    sell[0] = 0;
    buy[0] = -prices[0];
    
    for(let i=1;i<prices.length;i++) {
        
        if(i===1) {
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i] + prices[i]);
        }
        else {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i] + prices[i]);  
        }
    }
    
    return sell[prices.length - 1];
};
