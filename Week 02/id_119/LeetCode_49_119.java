    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {

            Map<String, List<String>> result = new LinkedHashMap<>();
            for (String str : strs) {
                String charset = sortStr(str);
                if (!result.containsKey(charset)) {
                    result.put(charset, new LinkedList<>());
                }
                result.get(charset).add(str);
                Collections.sort(result.get(charset));
            }

            List<List<String>> l = new LinkedList<>();
            l.addAll(result.values());
            return l;
        }

        private String sortStr(String str) {
            char[] key = str.toCharArray();
            Arrays.sort(key);
            return Arrays.toString(key);
        }
    }
