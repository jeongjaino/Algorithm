class Solution {
    fun solution(hp: Int): Int {
        var leftHp = hp % 5
        var total = hp / 5
        var leftHp2 = leftHp % 3
        total += leftHp / 3 + leftHp2 
        return total 
    }
}