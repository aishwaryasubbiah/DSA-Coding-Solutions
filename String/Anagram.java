/* https://leetcode.com/problems/valid-anagram/description/ */

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for(int i=0; i<s.length(); i++){
            if(hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
            else {
                hm.put(s.charAt(i), 1);
            }
        }
        for(int i=0; i<t.length(); i++){
            if(hm.containsKey(t.charAt(i))) {
                hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);
            }
            else {
                return false;
            }
        }
        for(int i=0; i<s.length(); i++){
            if(hm.get(s.charAt(i)) != 0) return false;
        }
        return true;

    }
}

/* Notes
1. Use one hashmap to store the first string with its corresponding letter count
2. Loop the second string and reduce the letter occurence in Hash map
3. If any character from second string is not present in hashmap, it is not anagram. 
4. At last, if every value in hashmap is 0, it is Anagram else false
*/