import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }
    public EpisodeIterator forwardIterator() {
        return new SeasonIterator(episodes);
    }
    public EpisodeIterator reverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }
    public EpisodeIterator shuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return new Iterator<Episode>() {
            private final EpisodeIterator it = forwardIterator();

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Episode next() {
                return it.next();
            }
        };
    }
}
