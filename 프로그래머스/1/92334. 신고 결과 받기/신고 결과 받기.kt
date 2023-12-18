class Solution {
    fun solution(
        id_list: Array<String>, report_list: Array<String>, k: Int
    ): IntArray {
        val reportCountMap = HashMap<String, Int>()
        val reportIdMap = HashMap<String, MutableList<String>>() 
        
        for(report in report_list) {
            val reportList = report.split(" ")
            val reportId = reportList[0] // 리폿 한 사람 
            val reporttedId = reportList[1] // 리폿 당한 사람 
            
            // 신고한 사람 등록 
            if(reportIdMap.containsKey(reporttedId)) {
                val reportIdList = reportIdMap.get(reporttedId)!!
                if(reportId in reportIdList) { // 이미 신고한 사람이라면 
                    continue
                }
                
                reportIdList.add(reportId)
                reportIdMap.put(reporttedId, reportIdList)
            }
            else {
                reportIdMap.put(reporttedId, mutableListOf(reportId))
            }
            
            // 신고 당한 횟수 추가 
            if(reportCountMap.containsKey(reporttedId)) {
                val count = reportCountMap.get(reporttedId)!!
                reportCountMap.put(reporttedId, count + 1)
            }
            else {
                reportCountMap.put(reporttedId, 1)
            }
        }
        
        val result = IntArray(id_list.size) { 0 }
        
        val reporttedIdList = reportCountMap.keys
        for(reporttedId in reporttedIdList) {
            val count = reportCountMap.get(reporttedId) ?: 0
            
            if (count >= k) {
                val reportIdList = reportIdMap.get(reporttedId) ?: mutableListOf()
                for (reportId in reportIdList) { // 신고 한 사람 
                    val index = id_list.indexOf(reportId)
                    result[index] += 1
                }
            }
        }
        
        return result
    }
}
