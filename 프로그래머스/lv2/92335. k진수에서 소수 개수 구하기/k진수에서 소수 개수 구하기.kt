class Solution {
    fun solution(n: Int, k: Int): Int {
        var result = 0
        val num = n.toString(k)
        var temp = ""
        for(c in num){
            if(c != '0'){
                temp += c
            }
            else{
                if(temp.isNotEmpty() && isPrime(temp.toLong())){
                    println(temp)
                    result += 1
                }
                temp = ""
            }
        }
        if(temp.isNotEmpty() && isPrime(temp.toLong())){
            println(temp)
            result += 1
        }
        return result
    }
    
    fun isPrime(n : Long): Boolean{
        if(n < 2.toLong()){
            return false
        }
        val endPoint = Math.sqrt(n.toDouble()).toInt()
        for(i in 2 .. endPoint){
            if((n % i).toInt() == 0){
                return false
            }
        }
        return true
    }
}