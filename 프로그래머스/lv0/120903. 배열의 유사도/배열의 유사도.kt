class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        return s1.toList().intersect(s2.toList()).size
    }
}