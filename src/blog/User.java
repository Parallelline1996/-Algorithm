package blog;


public class User implements Comparable<User> {

    private String name;
    private String phoneNumber;
    private Integer old;

    User(){}

    User(Integer old) {
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }


    @Override
    public int compareTo(User o) {
        if (this.old > o.old) {
            return 1;
        } else if (this.old < o.old) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "old=" + old +
                '}';
    }
}
