class Solution {
    fun solution(s: String): String = s.split(" ").joinToString(" ") { it.lowercase().replaceFirstChar { it.uppercase() } }
}