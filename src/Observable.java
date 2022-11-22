public interface Observable {
    public void addSubscriber();

    public void removeSubscriber();

    public void sendUpdate();
}
