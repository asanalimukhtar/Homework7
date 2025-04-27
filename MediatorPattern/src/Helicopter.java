public class Helicopter extends Aircraft {
    public Helicopter(String id, int fuel) {
        super(id, fuel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("[" + id + "][Helicopter] " + msg);
    }
}