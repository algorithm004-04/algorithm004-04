import collections


def groupAnagrams(strs):
    res = {}
    for s in strs:
        print("s:", s)
        key = tuple(sorted(s))              # key 为每个元素排序之后的元素
        print("key=s:", key)
        print("res.get(key,[]) :", res.get(key, []))
        print("res.get(key, []) + [s]:", res.get(key, []) + [s])
        res[key] = res.get(key, []) + [s]   # 将相同key值的value添加在一起，如果res中没有key，则创建一个res[key] = [s]
        print("res:", res)
        print("---------------")
    return list(res.values())


ex = ["eat", "tea", "tan", "ate", "nat", "bat"]
print(groupAnagrams(ex))

print(sorted('yong'))
