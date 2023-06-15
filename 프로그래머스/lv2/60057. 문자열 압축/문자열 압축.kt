class Solution {
    fun solution(s: String): Int {       
        var minLen = s.length
        for(i in 1 .. s.length / 2){
            minLen = minOf(minLen, supress(i, s))
        }
        return minLen
    }
    
    fun supress(slen : Int, s: String): Int{        
        var supStr = "" 
        var count = 1
        var previous = ""
        for(i in 0 .. (s.length - slen) step slen){
            val sliceStr = s.slice(i until i + slen)
            if(previous != sliceStr){
                if(count != 1){
                    supStr += (count.toString() + previous) 
                }
                else{
                    supStr += previous
                }
                previous = sliceStr
                count = 1
            }else{
                count += 1
            }
        }
        val len = s.length
        val left = s.slice(len - (len % slen) until len) // 남은 부분
        if(count == 1){
            return (supStr + previous + left).length
        }
        else {
            return (supStr + count.toString() + previous + left).length
        }        
    }
}