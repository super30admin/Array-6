// Time , Space - O(N), O(1)
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if(prices == null || prices.length == 0) {
        return 0;
    }
    
    let min1 = Infinity, profit1 = 0;
    let min2 = Infinity, profit2 = 0;
    
    for(let i=0; i< prices.length;i++) {
        min1 = Math.min(min1, prices[i]);
        profit1 = Math.max(prices[i] - min1, profit1);
        min2 = Math.min(prices[i] - profit1, min2);
        profit2 = Math.max(prices[i] - min2, profit2);
    }
    
    return profit2;
};
