class Solution {
    fun solution(n: Int): Int {
        for(i in 1 .. n / 2){
            if(i * i == n){
                return 1
            }
        }
        return 2
    }
}