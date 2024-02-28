import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        List<String[]> targetChars = new ArrayList<>();
        for (String target : targets) {
            targetChars.add(target.split(""));
        }



        for (int i = 0; i < targetChars.size(); i++) {
            for (String s : targetChars.get(i)) {
                int index = Integer.MAX_VALUE;
                for (int j = 0; j < keymap.length; j++) {
                    if (keymap[j].indexOf(s) + 1 < index && keymap[j].contains(s)) {
                        index = keymap[j].indexOf(s) + 1;
                    }
                }
                if (index == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += index;
            }
        }

        return answer;
    }
}