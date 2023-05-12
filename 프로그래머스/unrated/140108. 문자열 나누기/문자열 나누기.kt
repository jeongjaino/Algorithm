class Solution {
    fun solution(s: String): Int {
        var ns = s
        var result = 0
        // 더이상 읽을 글자가 없다면, 지금까지 읽은 문자열을 분리하고
        while(ns.length > 1){
            var fc = 0
            var oc = 0
            val x = ns.first()
            for(i in ns){
                if(i == x){
                    fc += 1
                }
                else{
                    oc += 1
                }
                if(fc == oc){
                    break
                }
            }
            result += 1
            ns = ns.slice(fc + oc until ns.length)
        }
        return if(ns.isNotEmpty()) result + 1 else result
    }
}