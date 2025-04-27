import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffledList;
    private int currentIndex = 0;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        this.shuffledList = new ArrayList<>(episodes);
        Collections.shuffle(this.shuffledList, new Random(seed));
    }

    @Override
    public boolean hasNext() {
        return currentIndex < shuffledList.size();
    }

    @Override
    public Episode next() {
        return shuffledList.get(currentIndex++);
    }
}