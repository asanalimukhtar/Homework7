import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> planes = new ArrayList<>();
        Random rnd = new Random();

        // spawn and register 10 aircraft with random fuel levels
        for (int i = 1; i <= 10; i++) {
            int fuel = rnd.nextInt(100) + 1;
            Aircraft ac;
            if (i % 3 == 0) ac = new Helicopter("H" + i, fuel);
            else if (i % 3 == 1) ac = new PassengerPlane("P" + i, fuel);
            else ac = new CargoPlane("C" + i, fuel);

            tower.registerAircraft(ac);
            planes.add(ac);
        }

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger tick = new AtomicInteger();

        Runnable task = () -> {
            int t = tick.incrementAndGet();
            Aircraft ac = planes.get(rnd.nextInt(planes.size()));
            int action = rnd.nextInt(10);

            if (action == 0) {
                ac.send("MAYDAY", tower);
            } else if (action < 5) {
                ac.requestRunway(true, tower);
            } else {
                ac.requestRunway(false, tower);
            }

            tower.showQueues();
            System.out.println("------------------------------");

            if (t >= 20) {
                exec.shutdown();
                System.out.println("Simulation ended.");
            }
        };

        exec.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}