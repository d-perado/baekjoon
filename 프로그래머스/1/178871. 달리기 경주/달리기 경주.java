import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> rank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }

        for (String name : callings) {
            int cur = rank.get(name);
            int prev = cur - 1; 

            String front = players[prev];
            players[prev] = players[cur];
            players[cur] = front;

            rank.put(name, prev);
            rank.put(front, cur);
        }

        return players;
    }
}