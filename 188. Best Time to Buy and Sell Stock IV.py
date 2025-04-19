#Time: O(n*k)
#space: O(k)
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n= len(prices)
        buy= [float('inf')]* k
        sell= [-1]* k
        # print(buy,sell)

        for i in range(n):
            for j in range(k):
                # print('k is',k)
                if j==0:
                    buy[j]= min(prices[i],buy[j])
                else:
                    buy[j]=min(prices[i]-sell[j-1],buy[j])
                sell[j]= max(prices[i]-buy[j],sell[j])
        return sell[k-1]
        
