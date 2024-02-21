/* https://leetcode.com/problems/top-k-frequent-elements/description/ */

class pqData{
    int value, count;
    pqData(int value, int count){
        this.value = value;
        this.count = count;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
          
        for(int i=0; i< nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            }
            else {
                map.put(nums[i], 0);
            }
        } 
        PriorityQueue<pqData> pq = new PriorityQueue<pqData>((a,b) -> b.count - a.count);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            pq.add(new pqData(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        int count =1, l=0;
        while(!pq.isEmpty() && count <= k) {
            res[l++] = pq.peek().value;
            pq.remove();
            count++;
        }
        return res;
    }
}