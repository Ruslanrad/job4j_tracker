package ru.job4j.tracker;

public final class SingleTracker {
    private final Tracker tracker = new Tracker();
    private static SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }

    public static void main(String[] args) {
        Item item = new Item("test");
        SingleTracker singleTracker = SingleTracker.getInstance();
        singleTracker.add(item);
        System.out.println(singleTracker.findById(item.getId()));
        Item item1 = new Item("test1");
        singleTracker.replace(item.getId(), item1);
        System.out.println(singleTracker.findById(item.getId()));
        singleTracker.delete(item.getId());
        System.out.println(singleTracker.findById(item.getId()));
    }
}
