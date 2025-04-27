public class Main {
    public static void main(String[] args) {
// Create two seasons of “Silicon Valley”
Season season1 = new Season();
season1.addEpisode(new Episode("Minimum Viable Product", 1500));
season1.addEpisode(new Episode("The Cap Table", 1400));
season1.addEpisode(new Episode("Articles of Incorporation", 1350));

Season season2 = new Season();
season2.addEpisode(new Episode("Sand Hill Shuffle", 1550));
season2.addEpisode(new Episode("Runaway Devaluation", 1600));
season2.addEpisode(new Episode("Bad Money", 1450));

// 1) Forward order
        System.out.println(">>> Forward:");
        EpisodeIterator fwd = season1.createIterator();
        while (fwd.hasNext()) {
            System.out.println(fwd.next().getTitle());
        }

// 2) Reverse order
        System.out.println("\n>>> Reverse:");
        EpisodeIterator rev = season1.createReverseIterator();
        while (rev.hasNext()) {
            System.out.println(rev.next().getTitle());
        }

// 3) Shuffle order
        System.out.println("\n>>> Shuffle:");
        EpisodeIterator shf = season1.createShuffleIterator(42);
        while (shf.hasNext()) {
            System.out.println(shf.next().getTitle());
        }

// 4) Binge Mode through both seasons
        System.out.println("\n>>> Binge All:");
        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);
        EpisodeIterator binge = series.createBingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next().getTitle());
        }

// 5) For-each in the second season
        System.out.println("\n>>> For-each Season2:");
        for (Episode ep : season2) {
            System.out.println(ep.getTitle());
        }
    }
}