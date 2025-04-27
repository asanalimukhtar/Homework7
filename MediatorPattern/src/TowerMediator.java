public interface TowerMediator {
    //Broadcast a message to all other aircraft
    void broadcast(String msg, Aircraft sender);

    //Request runway for landing (isLanding=true) or takeoff (isLanding=false).Returns true when runway is cleared

    boolean requestRunway(Aircraft aircraft, boolean isLanding);
}
