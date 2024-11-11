package org.example;

import java.util.*;

public class ClimbingLeaderboardService {

    public List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();

        Stack<Integer> leaderboard = new Stack();

        for(Integer ranks : ranked) {
            if(leaderboard.isEmpty() || !Objects.equals(leaderboard.peek(), ranks)) {
                leaderboard.push(ranks);
            }
        }

        for(int i = 0; i < player.size(); i++) {
            if(leaderboard.isEmpty()) {
                leaderboard.add(player.get(i));
                result.add(1);
                continue;
            }
            if(player.get(i) > leaderboard.peek()) {
                leaderboard.pop();
                i--;
            } else if(player.get(i).equals(leaderboard.peek())) {
                result.add(leaderboard.size());
            } else {
                result.add(leaderboard.size() + 1);
            }
        }

        return result;
    }
}