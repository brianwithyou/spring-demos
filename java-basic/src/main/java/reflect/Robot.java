package reflect;

/**
 * @author brian
 */
public class Robot {

    private String name;

    public void sayHi(String sentence) {
        System.out.println(sentence + ", " + name);
    }

    private String returnHello(String name) {
        return "hello, I am " + name;
    }
}
