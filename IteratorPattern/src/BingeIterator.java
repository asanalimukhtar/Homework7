import java.util.List;

//An iterator that iterates through all episodes from all seasons in a row
public class BingeIterator implements EpisodeIterator {
    private final List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator current;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            current = seasons.get(0).createIterator();
        }
    }

    @Override
    public boolean hasNext() {
        if (current == null) return false;
        if (current.hasNext()) return true;
        seasonIndex++;
        if (seasonIndex < seasons.size()) {
            current = seasons.get(seasonIndex).createIterator();
            return hasNext();
        }
        return false;
    }

    @Override
    public Episode next() {
        return current.next();
    }
}