class Solution(object):

    def firstUniqChar(self, s: str) -> int:
        # 先假设最小索引为最后的字符索引
        min_unique_char_index = len(s)

        # 已知字符串由小写字母构成，则遍历a-z
        for c in "abcdefghijklmnopqrstuvwxyz":
            i = s.find(c)
            # 分别从目标的字符串头和字符串尾查找对应字母的索引；如果两索引相等，则说明是单一字符
            if i != -1 and i == s.rfind(c):
                # 更新最新的最小索引
                min_unique_char_index = min(min_unique_char_index, i)

        # 如果返回值不为最后字符的索引，则返回最小索引值
        # 否则，根据题意，返回-1
        return min_unique_char_index if min_unique_char_index != len(s) else -1


if __name__ == "__main__":
    solution = Solution()
    print(solution.firstUniqChar("loveleetcode"))