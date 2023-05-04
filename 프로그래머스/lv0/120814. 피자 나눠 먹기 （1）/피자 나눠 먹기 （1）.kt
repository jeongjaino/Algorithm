class Solution {
    fun solution(n: Int): Int {
        if(n % 7 == 0){
            return n / 7
        }
        else{
            return n / 7 + 1
        }
    }
}