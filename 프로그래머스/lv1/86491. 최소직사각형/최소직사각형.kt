class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        val ns = Array(sizes.size){ IntArray(sizes.first().size) }
        for(i in sizes.indices){
            ns[i] = sizes[i].copyOf()
            ns[i].sortDescending()
        }
        return mm(ns)
    }
    
    fun mm(sizes: Array<IntArray>): Int{
        var mrow = 0
        var mcol = 0
        for(i in sizes){
            mrow = maxOf(i[0], mrow)
            mcol = maxOf(i[1], mcol)
        }
        return mrow * mcol 
    }
}