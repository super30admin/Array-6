class Solution:
    # TC : O(n)
    # SC : O(n)
    def maxProfit(self, k: int, prices: List[int]) -> int:
        def max_profit_with_index(prices):
            min_price = float('inf') 
            max_profit = 0  
            min_index = 0  
            buy_index = 0 
            sell_index = 0 

            for i, price in enumerate(prices):
                if price < min_price:
                    min_price = price  
                    min_index = i 

                current_profit = price - min_price
                if current_profit > max_profit:
                    max_profit = current_profit  
                    buy_index = min_index
                    sell_index = i 

            return max_profit, buy_index, sell_index

        def recur(prices, res):
            if len(prices) < 2:
                return 0

            profit, buy, sell = max_profit_with_index(prices)
            if profit == 0:
                return
            res.append(profit)

            recur(prices[:buy], res)
            recur(prices[sell + 1:], res)
            temp = list(reversed(prices[buy:sell]))
            recur(temp, res)

        res = []
        recur(prices, res)
        res.sort()
        res.reverse()

        return sum(res[:k])