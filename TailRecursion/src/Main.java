public class Main {

    public static void tailRecursive( String input, int level ) {
        // oneMB memory object for testing
        byte[] oneMB = new byte[1024*1024];

        if (level <= 0) {
            return;
        }

        System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());

        tailRecursive(input, --level);
    }

    public static void main(String[] args) {
        tailRecursive("test", 50);
    }
}