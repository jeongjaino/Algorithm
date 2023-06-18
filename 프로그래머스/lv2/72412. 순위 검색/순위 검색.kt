class Solution {
    private var infoMap = hashMapOf<String, MutableList<Int>>()
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val queryList : List<List<String>> = query.map{
            it.replace("and ", "").split(" ")
        }
        info.forEach{
            createInfoKey(it.split(" "), "", 0)
        }
        for(key in infoMap.keys){
            infoMap[key]!!.sort()
        }
        val result = mutableListOf<Int>()
        queryList.forEach{ it -> 
            val key = it.slice(0 until it.size - 1).joinToString("")
            val score = it.last().toInt()
            if(infoMap.containsKey(key)){
                result.add(binarySearch(infoMap[key]!!.toList(), score))
            }else{
                result.add(0)
            }
        }
        return result.toIntArray()
    }

    fun createInfoKey(info: List<String>, key: String, count: Int){
        if(count == 4){
            if(!infoMap.containsKey(key)){
                infoMap.put(key, mutableListOf())
            }
            infoMap[key]!!.add(info[4].toInt())
            return
        }
        createInfoKey(info, key + "-", count + 1)
        createInfoKey(info, key + info[count], count + 1)
    }
    
    fun binarySearch(list : List<Int>, score: Int): Int{
        var start = 0 
        var end = list.size - 1
        while(start <= end){
            val mid = (start + end) / 2
            if(list[mid] < score){
                start = mid + 1
            }
            else{
                end = mid - 1
            }
        }
        return list.size - start
    }
}