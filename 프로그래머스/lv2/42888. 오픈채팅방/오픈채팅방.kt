class Solution {
    fun solution(record: Array<String>): Array<String> {
        val uidMap = HashMap<String, String>()
        record.forEach{
            val list = it.split(" ")
            if(list[0] != "Leave"){
                uidMap.put(list[1], list[2])
            }
        }
        val result : MutableList<String> = mutableListOf()
        record.forEach{
            val list = it.split(" ")
            if(list[0] == "Enter"){
                result.add(uidMap.get(list[1])!! + "님이 들어왔습니다.")
            }
            else if(list[0] == "Leave"){
                result.add(uidMap.get(list[1])!! + "님이 나갔습니다.")
            }
        }
        return result.toTypedArray()
    }
}