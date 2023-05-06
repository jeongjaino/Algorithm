class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        if(n.toInt() == 1){
            return 4
        }
        for(i in 1 .. n / 2){
            if(i * i == n){
                return (i + 1) * (i + 1)
            }
        }
        return -1 
    }
}