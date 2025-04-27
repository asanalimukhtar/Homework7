public class Episode {
    private final String title;
    private final int runtimeSeconds;

    public Episode(String title, int runtimeSeconds) {
        this.title = title;
        this.runtimeSeconds = runtimeSeconds;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntimeSeconds() {
        return runtimeSeconds;
    }

    @Override
    public String toString() {
        return title;
    }
}