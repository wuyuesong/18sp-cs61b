public class OffByN implements CharacterComparator {
    private int n;

    OffByN(int N) {
        n = N;
    }

    public boolean equalChars(char x, char y) {
        if(x - y == n || x - y == -n) {
            return true;
        }
        return false;
    }
}
