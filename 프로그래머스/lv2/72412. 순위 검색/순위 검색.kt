class Solution {
    private var infoMap = hashMapOf<String, ArrayList<Int>>()
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        info.forEach{
            createInfoKey(it.split(" "), "", 0)
        }
        for(key in infoMap.keys){
            infoMap[key]!!.sort()
        }
        val result = IntArray(query.size){ 0 }
        val queryList : List<List<String>> = query.map{
            it.replace("and ", "").split(" ")
        }
        query.forEachIndexed{ index, it ->
            val q = it.replace(" and ", "").split(" ")
            if(infoMap.containsKey(q[0])){
                result[index] = (binarySearch(infoMap[q[0]]!!, q[1].toInt()))
            }
        }
        return result
    }

    fun createInfoKey(info: List<String>, key: String, count: Int){
        if(count == 4){
            if(!infoMap.containsKey(key)){
                infoMap.put(key, ArrayList<Int>())
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