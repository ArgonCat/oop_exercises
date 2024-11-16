public class Main {
    public static int lowestCommon( long a, long b) {
        for( int i = 0; i < 64; i++) {
            if((a&1L)==(b&1L)) {
                return i;
            }

            a = a >>> 1;
            b = b >>> 1;

            if (a==0 || b==0) {
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(lowestCommon(8,15));
    }
}