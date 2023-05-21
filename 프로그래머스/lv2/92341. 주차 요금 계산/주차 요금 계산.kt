class Solution {
    private var defaultMoney = 0 
    private var defaultTime = 0
    private var unitMoney = 0
    private var unitTime = 0
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        defaultTime = fees[0]
        defaultMoney = fees[1]
        unitTime = fees[2]
        unitMoney = fees[3]
        
        val totalMap = HashMap<String, Int>() // 번호, 총 누적 시간
        val entranceMap = HashMap<String, String>() // 번호, 입차 시간
        
        records.forEach{
            val record : List<String> = it.split(" ") // 입차시간, 번호, 인/아웃
            if(record[2] == "IN"){
                entranceMap.put(record[1], record[0])
            }
            else{
                val entranceTime = entranceMap.get(record[1])!!
                totalMap.put(record[1], (totalMap.get(record[1]) ?: 0) 
                             + countTime(record[0], entranceTime))
                entranceMap.remove(record[1])
            }
        }
        // 나가지 않은 차들 
        entranceMap.keys.forEach{
            val entranceTime = entranceMap.get(it)!!
                totalMap.put(it, (totalMap.get(it) ?: 0) + countTime("23:59", entranceTime))
        }
        
        val result : MutableList<Int> = mutableListOf()
        totalMap.keys.sorted().forEach{ num ->
            result.add(countMoney(totalMap.get(num)!!))
        }
        return result.toIntArray()
    }
    
    fun countTime(a : String, b : String) : Int{
        val hour = a.slice(0 .. 1).toInt() - b.slice(0 .. 1).toInt()
        val min = a.slice(3 .. 4).toInt() - b.slice(3 .. 4).toInt()
        return Math.abs(hour * 60 + min)
    }
    
    fun countMoney(t : Int) : Int{
        if(t <= defaultTime){
            return defaultMoney
        }
        else{
            if((t - defaultTime) % unitTime == 0){
                return (defaultMoney + (t - defaultTime) / unitTime * unitMoney)
            }
            else{
                return (defaultMoney + ((t - defaultTime) / unitTime + 1) * unitMoney)
            }
        }
    }
}