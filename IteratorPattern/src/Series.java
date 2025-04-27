import java.util.*;

//Series: stores seasons and returns a "binge" iterator
public class Series {
    private final List<Season> seasons = new ArrayList<>();

    public void addSeason(Season season) {
        seasons.add(season);
    }

    public EpisodeIterator createBingeIterator() {
        return new BingeIterator(seasons);
    }
}