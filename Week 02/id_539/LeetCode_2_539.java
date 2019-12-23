class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1. 如果输入为空，返回空链表
        if (strs==null || strs.length==0){
            return Collections.emptyList();
        }

        //2. 遍历链表中每个元素，对字符串内容排序
        //   以排序后的内容为key，到map中查找对应分组并执行合并操作
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] keyArr = strs[i].toCharArray();
            Arrays.sort(keyArr);
            String key = String.valueOf(keyArr);

            if (!map.containsKey(key)){
                List<String> contentList = new ArrayList<>();
                map.put(key, contentList);
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}