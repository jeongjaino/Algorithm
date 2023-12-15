class Solution {
    fun solution(n: Int): Int {
        for (value in 1 .. n) {
            if(n % value == 1)
                return value
        }
        return -1
    }
}