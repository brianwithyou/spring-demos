package proxy;

/**
 * @author brian
 */
public class User implements UserInterface {

    private String name;

    private Integer age;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("hello, I'm " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
