package javaAssignment;
import java.util.*;

class CD implements Comparable<CD> {
    String title;
    String singer;

    CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public int compareTo(CD other) {
        return this.singer.compareTo(other.singer);
    }

    public String toString() {
        return "CD [Title=" + title + ", Singer=" + singer + "]";
    }

    public static void main(String[] args) {
        List<CD> cds = new ArrayList<>();
        cds.add(new CD("Thriller", "Michael Jackson"));
        cds.add(new CD("25", "Adele"));
        cds.add(new CD("Divide", "Ed Sheeran"));

        Collections.sort(cds);
        cds.forEach(System.out::println);
    }
}
