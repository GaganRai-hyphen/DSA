// Last updated: 4/15/2026, 3:42:52 PM
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : stones) pq.offer(a);
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            int diff = Math.abs(first-second);
            pq.offer(diff);
        }
        return pq.poll();
    }
}