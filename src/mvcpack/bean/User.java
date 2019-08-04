package mvcpack.bean;

public class User {
    private String name;
    private long id;
    private int level;

    public static final User NULL_USER = new User();

    public User(String name, long id, int level) {
        this.name = name;
        this.id = id;
        this.level = level;
    }

    public User() {
        this("", 0, 0);
    }

    public boolean isNew() {
        return id == 0;
    }

    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            return NULL_USER;
        }
    }

    public User clone(long newId) {
        if (this == NULL_USER) {
            return NULL_USER;
        }
        return new User(name, newId, level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }
}
