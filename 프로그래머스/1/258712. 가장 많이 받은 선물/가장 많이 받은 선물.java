import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> giverIndex = new HashMap<>();
        Map<String, Integer> receiverIndex = new HashMap<>();

        for (String friend : friends) {
            giverIndex.put(friend, 0);
            receiverIndex.put(friend, 0);
        }

        for (String gift : gifts) {
            String[] index = gift.split(" ");
            giverIndex.put(index[0], giverIndex.get(index[0]) + 1);
            receiverIndex.put(index[1], receiverIndex.get(index[1]) + 1);
        }

        Map<String, Integer> giftIndex = new HashMap<>();

        for (String friend : friends) {
            int giveCount = giverIndex.get(friend);
            int receiveCount = receiverIndex.get(friend);

            giftIndex.put(friend, giveCount - receiveCount);
        }

        for (int i = 0; i < friends.length; i++) {
            int index = 0;

            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    int exchangeIndex = 0;
                    for (String gift : gifts) {
                        if (gift.equals(friends[i] + " " + friends[j])) exchangeIndex++;
                        if (gift.equals(friends[j] + " " + friends[i])) exchangeIndex--;
                    }
                    if (exchangeIndex > 0) index++;
                    if (exchangeIndex == 0 && giftIndex.get(friends[i]) > giftIndex.get(friends[j])) index++;
                }
            }

            if (index > answer) answer = index;
        }

        return answer;
    }
}