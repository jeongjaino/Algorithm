class Solution {
    fun solution(arr: IntArray): Int {
        var result = arr.first()
        arr.forEach{
            result = lcm(result, it) 
        }
        return result
    }
    
    fun lcm(a : Int, b : Int): Int{
        return a * b / gcb(a, b)
    }
    
    fun gcb(a : Int, b : Int): Int{
        if(b == 0){
            return a
        }
        return gcb(b, a % b)
    }
}