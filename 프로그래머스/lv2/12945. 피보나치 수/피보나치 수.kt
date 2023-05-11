class Solution {
    private lateinit var d : IntArray
    fun solution(n: Int): Int {
        d = IntArray(n + 1)
        d[1] = 1
        return pivo(n) 
    }
    
    fun pivo(n: Int) : Int{
        if(n == 0){
            return n
        }
        if(d[n] != 0){
            return d[n]
        }
        d[n] = (pivo(n - 1) % 1234567 + pivo(n - 2) % 1234567) % 1234567
        return d[n]
    }
}