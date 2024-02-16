import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        for (int i = 0; i < park.length; i++) {
            int index = park[i].indexOf("S");

            if (index != -1) {
                answer[0] = i;
                answer[1] = index;
                break;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            int distance = Integer.parseInt(route[1]);

            if (route[0].equals("E")) {
                if (park[0].length() - answer[1] > distance) {
                    if (!park[answer[0]].substring(answer[1] + 1, answer[1] + distance + 1).contains("X")) {
                        answer[1] += distance;
                    }
                }
            }
            if (route[0].equals("W")) {
                if (answer[1] >= distance) {
                    if (!park[answer[0]].substring(answer[1] - distance, answer[1]).contains("X")) {
                        answer[1] -= distance;
                    }
                }
            }
            if (route[0].equals("S")) {
                if (park.length - answer[0] > distance) {
                    boolean indexBool = true;
                    for (int j = 1; j <= distance; j++) {
                        if (park[answer[0] + j].substring(answer[1], answer[1] + 1).contains("X")) {
                            indexBool = false;
                            break;
                        }
                    }
                    if (indexBool) answer[0] += distance;
                }
            }
            if (route[0].equals("N")){
                if (answer[0] >= distance) {
                    boolean indexBool = true;
                    for (int j = 1; j <= distance; j++) {
                        if (park[answer[0] - j].substring(answer[1], answer[1] + 1).contains("X")) {

                            indexBool = false;
                            break;
                        }
                    }
                    if (indexBool) answer[0] -= distance;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}