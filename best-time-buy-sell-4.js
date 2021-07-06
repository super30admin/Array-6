// Time, Space - O(NK), O(K)

var maxProfit = function(k, prices) {
    
    if(prices == null || prices.length == 0) {
        return 0;
    }
    
    let buy = new Array(k+1);
    buy.fill(Infinity);
    let sell = new Array(k+1);
    sell.fill(0);
    
    if( 2 * k > prices.length) {
        let profit = 0;
        for(let i=1;i<prices.length;i++) {
            profit += (Math.max(0, prices[i] - prices[i-1]));
        }
        
        return profit;
    }
    
    for(let i=0;i<prices.length;i++) {
        for(let j=1;j<buy.length;j++) {
            buy[j] = Math.min(buy[j], prices[i] - sell[j-1]);
            sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            
        }
    }
    
    return sell[k];
};
