class Solution {
    private lateinit var d : LongArray
    fun solution(n: Int): Long {
        d = LongArray(2001)
        d[1] = 1
        d[2] = 2
        return jump(n)
    }
    
    fun jump(n : Int): Long{
        if(n <= 2){
            return n.toLong()
        }
        if(d[n] != 0.toLong()){
            return d[n]
        }
        d[n] = (jump(n - 2) * 2 + (jump(n - 1) - jump(n - 2))) % 1234567
        return d[n]
    }
}