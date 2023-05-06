class Solution {
    fun solution(phone_number: String): String {
        val length = phone_number.length
        return ("*").repeat(length-4) + phone_number.slice(length - 4 until length)
    }
}