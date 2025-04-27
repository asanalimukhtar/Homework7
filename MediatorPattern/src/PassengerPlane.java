public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, int fuel) {
        super(id, fuel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[" + id + "][Passenger] " + msg);
    }
}