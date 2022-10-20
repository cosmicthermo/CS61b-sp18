public class OffByN implements CharacterComparator {
    private int num;

    public OffByN(int n) {
        num = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return diff == num || diff == -num;
    }

}
