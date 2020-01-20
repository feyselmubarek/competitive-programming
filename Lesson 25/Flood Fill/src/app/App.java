// question link : https://leetcode.com/problems/flood-fill/submissions/
package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentColorVal = image[sr][sc];
        if (currentColorVal == newColor)
            return image;
        image[sr][sc] = newColor;

        // upper
        if (sr - 1 >= 0 && image[sr - 1][sc] == currentColorVal) {
            floodFill(image, sr - 1, sc, newColor);
        }

        // down
        if (sr + 1 < image.length && image[sr + 1][sc] == currentColorVal) {
            floodFill(image, sr + 1, sc, newColor);
        }

        // left
        if (sc - 1 >= 0 && image[sr][sc - 1] == currentColorVal) {
            floodFill(image, sr, sc - 1, newColor);
        }

        // right
        if (sc + 1 < image[0].length && image[sr][sc + 1] == currentColorVal) {
            floodFill(image, sr, sc + 1, newColor);
        }

        return image;
    }
}