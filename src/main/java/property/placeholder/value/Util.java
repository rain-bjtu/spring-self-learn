package property.placeholder.value;

public class Util {

    private Util() {}

    public static void printDisc(CompactDisc disc) {
        final String separator = "------------------------------------------------------";
        System.out.println(separator);
        System.out.println("The title is: " + disc.getTitle());
        System.out.println("The artist is: " + disc.getArtist());
        System.out.println("Now is playing!");
        System.out.println(separator);
    }
}
