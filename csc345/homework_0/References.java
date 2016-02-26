public class References {
    static class Int {
        int value;

        public Int(int value) {
            this.value = value;
        }

        public void setInt(int value) {
            this.value = value;
        }

        public int getInt() {
            return value;
        }
    }

    private static int square(Int i) {
        i.setInt(i.getInt() * i.getInt());

        return i.getInt();
    }

    private static int twice(Int i) {
        i.setInt(2 * i.getInt());

        return i.getInt();
    }

    private static int once(Int i) {
        return i.getInt();
    }

    public static void main(String[] args) {
        Int x = new Int(3);
        int y = square(x) + twice(x) + once(x);
        System.out.println(y);
    }
}