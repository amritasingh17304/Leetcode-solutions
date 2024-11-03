/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographically in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 *
 * Asked in Facebook, Uber, Amazon, LinkedIn
 * */

class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    int i,j,n=words.length;
    int freq[] = new int[26];
    int rank=1;
    for(i=0;i<order.length();i++) {
      freq[order.charAt(i)-'a']=rank;
      rank++;
    }
    for(i=0;i<n-1;i++) {
      String s=words[i];
      String p=words[i+1];
      int a=0;
      while(a<s.length() && a<p.length()) {
        if(freq[s.charAt(a)-'a']>freq[p.charAt(a)-'a']) {
          return false;
        }
        else if(freq[s.charAt(a)-'a']==freq[p.charAt(a)-'a']) {
          a++;
        }
        else {
          break;
        }
      }
      if(p.length()<s.length() && a==p.length()) {
        return false;
      }
    }
    return true;
  }
}