class Solution:
    '''
    Accepted on leetcode(121)
    time - O(N)
    space - O(1)

    '''

    def maxProfit(self, prices: List[int]) -> int:
        min_value = float('inf')
        max_value = 0  # max profit

        for price in prices:
            # take the minimum value that appears in the list as the day to buy stocks to get max profit
            if price < min_value:
                min_value = price
            else:  # if not min value then calculate profit and compare with max profit
                max_value = max(max_value, price - min_value)

        return max_value