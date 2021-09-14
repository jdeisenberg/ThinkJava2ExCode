/*
 * Class to be used with ArrayList example in Chapter 13.
 *
 */

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Make sure nobody sets a negative age
    public void setAge(int age) {
        this.age = Math.abs(age);
    }
    
    public String toString() {
        return String.format("%s (%d)", name, age);
    }
    
    public int compareTo(Person other) {
        int result = name.compareToIgnoreCase(other.name);
        if (result == 0) {
            result = (this.age - other.age);
        }
        return result;
    }
}
