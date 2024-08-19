public class OffByN implements CharacterComparator {

    private int n;

    public OffByN(int N) {
        this.n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x + this.n == y || x - this.n == y;
    }
}
