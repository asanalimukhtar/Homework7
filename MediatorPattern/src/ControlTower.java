import java.util.*;

public class ControlTower implements TowerMediator {
    private final List<Aircraft> aircraftList = new ArrayList<>();
    private final Queue<Aircraft> landingQueue = new LinkedList<>();
    private final Queue<Aircraft> takeoffQueue = new LinkedList<>();

    //Register an aircraft to receive broadcasts
    public void registerAircraft(Aircraft ac) {
        aircraftList.add(ac);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if ("MAYDAY".equals(msg)) {
            System.out.println("--- EMERGENCY: " + sender.getId() + " MAYDAY! ---");
            // clear all queues of this sender
            landingQueue.remove(sender);
            takeoffQueue.remove(sender);
            // notify others to hold
            for (Aircraft ac : aircraftList) {
                if (ac != sender) ac.receive("Hold position: emergency landing in progress");
            }
            // immediate landing granted
            System.out.println("[" + sender.getId() + "] granted immediate emergency landing");
            return;
        }
        // normal broadcast to all others
        for (Aircraft ac : aircraftList) {
            if (ac != sender) ac.receive(msg);
        }
    }

    @Override
    public boolean requestRunway(Aircraft aircraft, boolean isLanding) {
        if (isLanding) {
            if (!landingQueue.contains(aircraft)) landingQueue.offer(aircraft);
            if (landingQueue.peek() == aircraft) {
                landingQueue.poll();
                return true;
            }
        } else {
            if (!takeoffQueue.contains(aircraft)) takeoffQueue.offer(aircraft);
            if (takeoffQueue.peek() == aircraft) {
                takeoffQueue.poll();
                return true;
            }
        }
        return false;
    }
    //Print current queue states
    public void showQueues() {
        System.out.print("Landing queue: ");
        for (Aircraft ac : landingQueue) System.out.print(ac.getId() + " ");
        System.out.print("| Takeoff queue: ");
        for (Aircraft ac : takeoffQueue) System.out.print(ac.getId() + " ");
        System.out.println();
    }
}