class Solution {
    fun solution(sides: IntArray): Int {
        sides.sort()
        return if (sides.first() + sides[1] > sides.last()) 1 else 2
    }
}