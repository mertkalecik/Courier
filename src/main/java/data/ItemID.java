package data;

public class ItemID {
    private static ItemID singleton = null;
    private int id;

    private ItemID(int id) {
        this.id = id;
    }

    private ItemID() {
    }

    public static ItemID getInstance(int id) {
        if (singleton ==null)
            singleton = new ItemID(id);

        singleton.setId(id);

        return singleton;
    }
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }
}
