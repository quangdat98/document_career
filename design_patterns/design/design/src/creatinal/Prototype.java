package creatinal;

public class Prototype implements Cloneable {
    private String name;
    private int age;

    public Prototype(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

