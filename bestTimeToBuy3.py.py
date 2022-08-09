'''
Solution:
1.  Only 2 transactions are allowed, and so keep updating the minimum buying price and potential profit at each instant
    with the available minimum buying price at that instant considering one transaction is done.
2.  Also, the second buying price would be removing the first profit amount to get the effective profit from entire transaction
Time Complexity:    O(N)
Space Complexity:   O(1)
Run on leetcode: Yes
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        '''
        buy1  = min(buy1,prices[i])
        sell1 = max(sell1,prices[i]-buy1)
        
        buy2  = min(buy2,prices[i]-sell1)
        # for buy2, whatever profit I have earned from my first transaction, subtract
        that profit when I am doing the second transactional buy
        sell2 = max(sell2,prices[i]-buy2)
        
        '''
        buy1 = float('inf')
        sell1 = float('-inf')
        
        buy2 = float('inf')
        sell2 = float('-inf')
        
        for i in range(0,len(prices)):
            buy1  = min(buy1,prices[i])
            sell1 = max(sell1,prices[i]-buy1)
        
            buy2  = min(buy2,prices[i]-sell1)
            sell2 = max(sell2,prices[i]-buy2)
        
        # print(sell2)
        return sell2