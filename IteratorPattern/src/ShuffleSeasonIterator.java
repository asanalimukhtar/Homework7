import java.util.*;

//Random order of episodes (with fixed seed)
public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffled;
    private int index = 0;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        this.shuffled = new ArrayList<>(episodes);
        Collections.shuffle(shuffled, new Random(seed));
    }

    @Override
    public boolean hasNext() {
        return index < shuffled.size();
    }

    @Override
    public Episode next() {
        return shuffled.get(index++);
    }
}