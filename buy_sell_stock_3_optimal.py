class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        T = O(N)
        S = O(1)
        '''
        if prices == None or len(prices) == 0 :
            return 0 
        buy1 = prices[0]
        sell1 = 0
        buy2 = prices[0]
        sell2 = 0
        for i in range(1, len(prices) ):
            buy1 = min(buy1 , prices[i])
            sell1 = max(sell1, prices[i] - buy1)
            buy2 = min(buy2 , prices[i] - sell1 )
            sell2 = max(sell2, prices[i] - buy2 )
        return sell2
    
    def BruteForcemaxProfit(self, prices: List[int]) -> int:
        return self.recursion( 0 , False , 2 , prices , -1 )
    
    def recursion(self, idx , bought, trans , prices , stock_price) -> int: 
        if idx < len(prices):
            if bought: 
                #case 1 - hold 
                profit_1 = 0
                profit_1 += self.recursion( idx+1, bought , trans , prices , stock_price )
                # case 2 - sell 
                profit_2 = 0 
                if trans > 0:
                    profit_2 += prices[idx] - stock_price
                    profit_2 += self.recursion( idx+1, not bought , trans-1 , prices , -1 )
                return max(profit_1 , profit_2  )

            else:
                # case 1 - buy 
                profit_1 = 0 
                if trans > 0 :
                    profit_1 = self.recursion( idx+1, not bought , trans , prices , prices[idx] )
                # case 2 - skip 
                profit_2 = self.recursion( idx+1, bought , trans , prices , -1 )
                return max(profit_1 , profit_2  )
        return 0 
        
        
        
        
        
