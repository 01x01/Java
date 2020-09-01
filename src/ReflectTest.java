/*
 * @Description: 程序在运行期间拿到对象的所有信息，会破坏封装性
 * @author: johnw;
 * @Created: 9/1/2020;
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(People.class.getName());
        System.out.println(People.class.getField("name")); // 只能是 public 的字段
        System.out.println(People.class.getDeclaredField("age")); // 可以得到公开的和私密的字段
        System.out.println(People.class.getMethod("getName")); // 得到公开方法的方法名
        System.out.println(People.class.getDeclaredMethod("sayHi")); // 可以得到公开和私密的方法

        // 通过反射设置值
        People p = new People("john",18);
        Field age = People.class.getDeclaredField("age");

        age.setAccessible(true);
        age.set(p, 20);

        System.out.println(p.getAge()); // 20

        // 通过反射拿到实例的值
        Field name = People.class.getField("name");
        System.out.println(name.get(p)); // john


        // 调用构造方法
        Constructor constructor = People.class.getConstructor(String.class, int.class);
        People people = (People) constructor.newInstance("jack",20);
        System.out.println(people.getName());

        // 调用方法
        // 通常普通方法，只有创建了实例才能够进行调用，所以这里的 Invoke 也要设置 实例对象
        Method m = People.class.getMethod("getName");
        String names = (String) m.invoke(people);
        System.out.println(names);

        // 调用静态方法， 与普通方法不同的是，不用通过实例来调用，所以这里使用 null 来作为 invoke 参数
        Method m2 = People.class.getDeclaredMethod("say");
        m2.invoke(null);

    }

}

class People {
    public String name;
    private int age;

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void sayHi(){
        System.out.println("Hi");
    }
    static void say(){
        System.out.println("I am static method");
    }
}