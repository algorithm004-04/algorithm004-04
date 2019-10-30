def isAnagram(s: str, t: str) -> bool:
    # 遍历 s 建立dict，每个字母出现一次+1
    # 遍历 t ，字母存在dict时，对应-1
    _dict = {}
    for i in s:
        if i not in _dict:
            _dict[i] = 1
        else:
            _dict[i] += 1
        print("_dict:", _dict)
        print("--------one--------")
    for j in t:
        if j in _dict:
            _dict[j] -= 1
        print("_dict:", _dict)
        print("--------two--------")
        if j not in _dict or _dict[j]:
            return False
    for n in _dict.values():
        print("n:", n)
        if n != 0:
            return False
    return True

# s = "a"
# t = "ab"
s = "anagram"
t = "nagaram"
print(isAnagram(s, t))
