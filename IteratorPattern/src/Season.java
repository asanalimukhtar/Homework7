import java.util.*;

//Season: stores episodes and produces different iterators
public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public EpisodeIterator createIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator createShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return new Iterator<>() {
            private final EpisodeIterator it = createIterator();
            @Override public boolean hasNext() { return it.hasNext(); }
            @Override public Episode next() { return it.next(); }
        };
    }
}