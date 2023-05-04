class Solution {
    fun solution(n: Int): IntArray {
        val length = if(n % 2 == 0) n / 2 else n / 2 + 1 
        return IntArray(length){ i -> i * 2 + 1}
    }
}