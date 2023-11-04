# Brute force - Comparing every element with rest of the elements in array and storing maximum profit for that element. Repeating thsi for all elements and updating maximum profit value. 
# TC - O(N*N)

# Optimal - Declaring first element as smallest. Traversing through array and finding the smallest element and then subtracting it from current element and checking/updating the max difference. 
# TC - O(n)


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        smallest = prices[0]
        maximum = 0
        for i in range(1,len(prices)):
            smallest = min(smallest, prices[i])
            maximum = max(maximum, prices[i]-smallest)
        return maximum
        