class Solution {
    fun solution(s: String, n: Int): String {
        return s.map{
            when{
                it.isLowerCase() -> { 'a' + (it + n - 'a') % 26 }
                it.isUpperCase() -> { 'A' + (it + n - 'A') % 26 }
                else -> { ' '}
            }
        }.joinToString("")
    }
}