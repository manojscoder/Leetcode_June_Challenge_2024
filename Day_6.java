// Problem link: https://leetcode.com/problems/hand-of-straights/description/
// Timee: O(n)
// Space: O(n)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int currCard;

        for(int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(int card : hand) {
            currCard = card;

            while(map.containsKey(currCard - 1) && map.get(currCard - 1) > 0) {
                currCard -= 1;
            }

            while(currCard <= card) {

                while(map.get(currCard) > 0) {

                    for(int i = currCard; i < currCard + groupSize; i++) {

                        if(!(map.containsKey(i) && map.get(i) > 0)) {
                            return false;
                        }

                        map.put(i, map.get(i) - 1);
                    }

                }

                currCard += 1;
            }
        }
        return true;
    }
}
