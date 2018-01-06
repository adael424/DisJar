import java.util.LinkedList;

public class PrintInterfaceImplementationsMenuOption extends OptionWithClassList implements MenuOption {


    public void execute(String[] commands) {
        LinkedList<Class> classes = createClassesList(commands[0]);
        if(classes!=null) {
            System.out.println("Classes implementing interface " + commands[2]);
            for (Class foo : classes) {
                if (!foo.isInterface())
                    for (Class foo2 : foo.getInterfaces()) {
                        if (foo2.getName().equals(commands[2])) {
                            System.out.println(foo.getName());
                        }
                    }
            }
        }
    }
    }
