class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var index1 = 0
        var index2 = 0
        for(word in goal){
            if(index1 < cards1.size && word == cards1[index1]){
                index1 ++
            }
            else if(index2 < cards2.size && word == cards2[index2]){
                index2 ++
            }
            else{
                return "No"
            }
        }
        return "Yes"
    }
}