class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var total: Long = 0
        for(i in 1 .. count){
            total += (price.toLong() * i.toLong())
        }
        return if(total > money) total - money else 0
    }
}