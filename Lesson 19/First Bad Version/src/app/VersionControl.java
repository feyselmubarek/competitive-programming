package app;

public class VersionControl {
    boolean isBadVersion(long current) {
        if (current >= 1702766719) {
            return true;
        }
        return false;
    }
}
