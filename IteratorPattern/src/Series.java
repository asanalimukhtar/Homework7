import java.util.ArrayList;
import java.util.List;

public class Series {
    private final List<Season> seasons = new ArrayList<>();

    public void addSeason(Season season) {
        seasons.add(season);
    }

    // Binge iterator through all seasons
    public EpisodeIterator bingeIterator() {
        return new BingeIterator(seasons);
    }
}