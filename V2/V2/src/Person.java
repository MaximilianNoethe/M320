public class Person {

    private String name;
    private int birthday;
    private String address;

    public Person(String name, int birthday, String address) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Birthday: " + birthday);
        System.out.println("Address: " + address);
    }

}
