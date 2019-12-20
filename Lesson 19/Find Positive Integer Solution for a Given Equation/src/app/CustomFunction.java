package app;

public class CustomFunction implements InnerCustomFunction {

    @Override
    public int f(int x, int y) {
        return x + y;
    }
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)

}

interface InnerCustomFunction {
    int f(int x, int y);
}