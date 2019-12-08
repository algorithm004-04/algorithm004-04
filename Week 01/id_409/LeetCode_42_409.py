class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) < 3:
            return 0
        left_bar, right_bar, volume = 0, 0, 0
        i, j = 0, len(height) -1
        while i<= j:
            left_bar, right_bar = max(left_bar, height[i]), max(right_bar, height[j])
            if left_bar < right_bar:
                volume += left_bar - height[i]
                i += 1
            else:
                volume += right_bar - height[j]
                j -= 1

        return volume
