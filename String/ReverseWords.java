/* https://leetcode.com/problems/reverse-words-in-a-string/description/ */

class Solution {
    public String reverseWords(String s) {
        String finalStr = "";
        int i = s.length()-1, end = s.length();
        while(i >= 0) {
           if(s.charAt(i) == ' ' && i+1 < s.length() && s.charAt(i+1) != ' ') {
               String currStr = s.substring(i+1, end);
               finalStr += (currStr + " ");
               end = i;
           } 
            else if(s.charAt(i) == ' ') end = i;
           i--;
        }
        String currStr = s.substring(i+1, end);
        finalStr += currStr;
        i = finalStr.length()-1;
        end = finalStr.length();
        while(i >=0) {
            if(finalStr.charAt(i) == ' ') {
                end = i;
                i--;
            } else {
                finalStr = finalStr.substring(0, end);
                break; 
            }
        }
        return finalStr;
    }
}