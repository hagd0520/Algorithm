class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 0, luy = wallpaper[0].length(), rdx = 0, rdy = 0;

        for (String wp : wallpaper) {
            if (luy > wp.indexOf("#") && wp.contains("#")) luy = wp.indexOf("#");
            if (rdy < wp.lastIndexOf("#")) rdy = wp.lastIndexOf("#");
        }

        rdy++;
        
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                lux = i;
                break;
            }
        }

        for (int i = wallpaper.length - 1; i >= 0; i--) {
            if (wallpaper[i].contains("#")) {
                rdx = i + 1;
                break;
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }
}