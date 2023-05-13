class Solution {
    private lateinit var playerList : Array<String>
    private lateinit var h : HashMap<String, Int>
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        h = HashMap<String, Int>()
        playerList = players
        for(i in players.indices){
            h.put(players[i], i)
        }
        for(i in callings.indices){
            val rank = h.get(callings[i])!! // 불린 친구의 랭크 
            h.put(playerList[rank], rank - 1)
            h.put(playerList[rank - 1], rank)
            swap(rank)
        }
        return playerList
    }
    fun swap(rank : Int){
        val temp = playerList[rank]
        playerList[rank] = playerList[rank - 1]
        playerList[rank - 1] = temp
    }
}