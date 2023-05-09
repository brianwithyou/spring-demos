package reflect;

/**
 * @author brian
 */
public class CglibUser {

    private String name;

    private Integer age;

    public CglibUser(String name) {
        this.name = name;
    }

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
