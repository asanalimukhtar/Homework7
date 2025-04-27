public class Main {
    public static void main(String[] args) {
        Season seasonOne = new Season();
        seasonOne.addEpisode(new Episode("Minimum Viable Product", 1500));
        seasonOne.addEpisode(new Episode("The Cap Table", 1400));
        seasonOne.addEpisode(new Episode("Articles of Incorporation", 1350));

        Season seasonTwo = new Season();
        seasonTwo.addEpisode(new Episode("Sand Hill Shuffle", 1550));
        seasonTwo.addEpisode(new Episode("Runaway Devaluation", 1600));
        seasonTwo.addEpisode(new Episode("Bad Money", 1450));

        // Forward Traversal
        System.out.println("Forward Traversal:");
        EpisodeIterator forward = seasonOne.forwardIterator();
        while (forward.hasNext()) {
            System.out.println(forward.next().getTitle());
        }

        // Reverse Traversal
        System.out.println("\nReverse Traversal:");
        EpisodeIterator reverse = seasonOne.reverseIterator();
        while (reverse.hasNext()) {
            System.out.println(reverse.next().getTitle());
        }

        // Shuffle Traversal
        System.out.println("\nShuffle Traversal:");
        EpisodeIterator shuffle = seasonOne.shuffleIterator(42);
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next().getTitle());
        }

        // Binge Mode
        System.out.println("\nBinge Mode:");
        Series series = new Series();
        series.addSeason(seasonOne);
        series.addSeason(seasonTwo);
        EpisodeIterator binge = series.bingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next().getTitle());
        }

        // For-each on Season Two
        System.out.println("\nFor-each on Season Two:");
        for (Episode ep : seasonTwo) {
            System.out.println(ep.getTitle());
        }
    }
}