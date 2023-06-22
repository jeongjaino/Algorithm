class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        plans.sortWith(compareBy { it[1] })
        val result = mutableListOf<String>()
        val leftWork = ArrayDeque<Pair<String, Int>>()
        var currentWork = 0
        while(result.size < plans.size){
            val time = if(currentWork < plans.lastIndex) { // 다음 작업간의 시간 차이 
                getTime(plans[currentWork + 1][1], plans[currentWork][1])
            }
            else if(currentWork == plans.lastIndex){
                plans[currentWork][2].toInt() // 마지막 작업인 경우 
            }
            else{
                break
            }
            // 다음 작업간의 시간차이 - 과제시간
            var difference = time - plans[currentWork][2].toInt()
            if(difference >= 0){ // 시간차이 > 과제 시간 
                result.add(plans[currentWork][0])
                while(difference > 0 && leftWork.isNotEmpty()){
                    val work = leftWork.last()
                    leftWork.removeLast()
                    difference -= work.second
                    if(difference >= 0){
                        // 남은 시간의 남은 작업 시간이 차이보다 작은 경우 
                        result.add(work.first)
                    }
                    else{
                        leftWork.add(Pair(work.first, -difference))
                    }
                }
            }
            else{ // 시간차이 < 과제 시간 
                leftWork.add(Pair(plans[currentWork][0], -difference))
            }
            currentWork += 1
        }
        for(i in leftWork.lastIndex downTo 0){
            result.add(leftWork[i].first)
        }
        return result.toTypedArray()
    }

    // aTime > bTime
    fun getTime(aTime : String, bTime : String): Int{
        var amin = aTime.replace(":", "").toInt()
        amin = amin / 100 * 60 + amin % 100
        var bmin = bTime.replace(":", "").toInt()
        bmin = bmin / 100 * 60 + bmin % 100
        return amin - bmin
    }
}