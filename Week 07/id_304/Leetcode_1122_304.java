class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[arr1.length];
        int cur = 0;
        for (int i = 0;i < arr1.length; i++){
            if (map.containsKey(arr1[i])){
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }else{
                map.put(arr1[i],1);
            }
        }

        for (int i = 0;i < arr2.length; i++){
            for (int j = 0; j < map.get(arr2[i]); j++){
                result[cur++] = arr2[i];
            }
            map.remove(arr2[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()){
            for (int j = 0; j < map.get(i); j++){
                list.add(i);
            }
        }

        Collections.sort(list);

        for (int item : list){
            result[cur++] = item;
        }

        return result;
    }
}
