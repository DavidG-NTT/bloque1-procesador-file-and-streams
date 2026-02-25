public class Person {
    private String name;
    private String town;
    private int age;

    public Person(String name, String town, int age) {
        this.age = age;
        this.town = town;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ':' + town + ':' + age;
    }
}
