public abstract class Aircraft {
    protected final String id;
    private Integer lastFuelLevel;

    public Aircraft(String id, int initialFuel) {
        this.id = id;
        this.lastFuelLevel = initialFuel;
    }

    //Handle incoming broadcast from tower
    public abstract void receive(String msg);

    //Send broadcast via tower
    public void send(String msg, TowerMediator tower) {
        tower.broadcast(msg, this);
    }

    //Request runway via tower
    public boolean requestRunway(boolean isLanding, TowerMediator tower) {
        boolean cleared = tower.requestRunway(this, isLanding);
        if (cleared) {
            String action = isLanding ? "landing" : "takeoff";
            System.out.println("[" + id + "] cleared for " + action);
        } else {
            System.out.println("[" + id + "] waiting for runway (" + (isLanding ? "land" : "takeoff") + ")");
        }
        return cleared;
    }

    public String getId() {
        return id;
    }
}