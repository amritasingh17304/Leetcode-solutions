/***
 * 796. Rotate String
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 *
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 * Example 1:
 *
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * Example 2:
 *
 * Input: s = "abcde", goal = "abced"
 * Output: false
 *
 * Asked in Zoom, Goldman Sachs, Apple, LinkedIn, Microsoft
 */
class Solution {
  public boolean rotateString(String s, String goal) {
    if(goal.length()!=s.length())
      return false;
    if(s.concat(s).indexOf(goal)!=-1)
      return true;
    return false;
  }
}


/** Another solution  */

class Solution {
  public boolean rotateString(String s, String goal) {
    if(s.length()!=goal.length())
      return false;
    return (s+s).contains(goal);
  }
}