package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int numTimesAllBlue(int[] light) {
        int rightMostLight = 0;
        int blueMoments = 0;
        int onLights = 0;

        for (int index = 0; index < light.length; index++) {
            rightMostLight = Math.max(rightMostLight, light[index]);
            onLights++;

            if (rightMostLight == onLights) {
                blueMoments++;
            }
        }

        return blueMoments;
    }
}