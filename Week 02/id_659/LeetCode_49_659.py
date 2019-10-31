class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hashmap = {}
        res_list=[]
        for i in strs:
            str_sort = "".join((lambda x: (x.sort(), x)[1])(list(i)))
            if hashmap.get(str_sort) is not None:
                str_list = hashmap[str_sort]
                str_list.append(i)
                hashmap[str_sort]=str_list
            else:
                hashmap[str_sort] = [i]

        for key,value in hashmap.items():
            res_list.append(value)

        return res_list