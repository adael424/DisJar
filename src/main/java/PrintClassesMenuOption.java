

import java.util.LinkedList;

public class PrintClassesMenuOption extends OptionWithClassList implements MenuOption {
    public void execute(String[] commands) {
        LinkedList<Class> classes = createClassesList(commands[0]);

        if(classes!=null) {
            for (Class foo : classes) {
                System.out.println(foo.isInterface() ? "i  " + foo.getCanonicalName() : "c  " + foo.getCanonicalName());
            }
        }
    }
}
