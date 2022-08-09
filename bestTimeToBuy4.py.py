'''
Solution:
1.  Only k transactions are allowed, and so keep updating the minimum buying price and potential profit at each instant
    with the available minimum buying price at that instant considering one transaction is done, extending the idea
    from previous two questions.
2.  Also, the kth buying price would be removing the (k-1)th profit amount.
3.  If k > n/2 => infinite transactions would be allowed as there can be atmost n/2 transactions, and so for that case
    just keep adding the positive slopes so that we get the maximum profit.
Time Complexity:    O(N * k)
Space Complexity:   O(k)
Run on LeetCode: Yes
'''
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        # base-case
        if k == 0 or len(prices)==0:
            return 0
        
        # if k >= len(prices)//2 --> book profit at every transaction
        if (k >= len(prices) // 2):
            profit = 0
            for i in range(1, len(prices)):
                profit += max(0, prices[i] - prices[i - 1])
            return profit
        
        # mainitain buy array and sell array upto length as k
        buy = [float('inf')]*k
        sell = [float('-inf')]*k
        
        # iterate the prices
        for i in range(0,len(prices)):
            for j in range(0,k):
                if j == 0:
                    buy[j]  = min(buy[j],prices[i])
                else:
                    buy[j]  = min(buy[j],prices[i]-sell[j-1])
                sell[j] = max(sell[j],prices[i]-buy[j])
            '''end of inner for loop'''
        '''end of outer for loop'''
        return sell[k-1]