import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class PrintClassDetailsMenuOption extends OptionWithClassList implements MenuOption {

    public void execute(String[] commands) {
        LinkedList<Class> classes = createClassesList(commands[0]);
        if(classes!=null) {
            for (Class foo : classes) {
                if (foo.getName().equals(commands[2])) {
                    while (!foo.getName().equals("java.lang.Object")) {
                        System.out.println("For class: " + foo.getName());

                        System.out.println("Fields: ");
                        for (Field field : foo.getDeclaredFields()) {
                            field.setAccessible(true);
                            System.out.println(field.toString());
                        }
                        System.out.println("Methods: ");
                        for (Method m : foo.getDeclaredMethods()) {
                            System.out.println(m.toString());
                        }
                        System.out.println("Constructors: ");
                        for (Constructor m : foo.getConstructors()) {
                            System.out.println(m.toString());
                        }
                        System.out.println();
                        foo = foo.getSuperclass();
                    }
                    break;
                }
            }
        }
    }

    }
