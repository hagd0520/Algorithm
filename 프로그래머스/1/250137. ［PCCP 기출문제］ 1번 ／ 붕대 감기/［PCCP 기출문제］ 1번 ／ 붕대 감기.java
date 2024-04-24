import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health;
        
        for (int i = 0; i < attacks.length; i++) {
            health -= attacks[i][1];
            
            if (health <= 0) {
                return -1;
            }
            
            if (i < attacks.length - 1) {
                int rest = attacks[i + 1][0] - attacks[i][0] - 1;
                health += bandage[1] * rest + (rest / bandage[0]) * bandage[2];
            }
            
            if (health > maxHealth) health = maxHealth;
            
        }
        
        answer = health;
                
        return answer;
    }
}