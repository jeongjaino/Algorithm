class Solution {
    private var result = 0
    private var k = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        this.k = k
        permute(dungeons, mutableListOf())
        return result
    }

    fun permute(dungeons: Array<IntArray>, tempList : MutableList<IntArray>){
        if(dungeons.size == tempList.size){
            checkDungeons(tempList.toList())
        }
        else{
            for(i in dungeons.indices){
                if(tempList.contains(dungeons[i])) continue
                tempList.add(dungeons[i])
                permute(dungeons, tempList)
                tempList.removeAt(tempList.size - 1)
            }
        }
    }

    fun checkDungeons(temp : List<IntArray>){
        var condition = k
        var possible = 0 // 입장 가능한 던전의 수 
        for(i in temp){
            if(condition >= i[0]){
                condition -= i[1]
                possible += 1
            }
            else{ return } 
            result = maxOf(result, possible)
        }
    }
}