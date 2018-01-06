

public class PrintHelpMenuOption implements MenuOption {
    public void execute(String[] commands) {
        System.out.println("To get all class and interface names input name of a jar file.");
        System.out.println("To get all interface implementations input name of the jar file as first argument \"-i\" as second argument and name of interface as the last argument.");
        System.out.println("To get all class details input name of the jar file as first argument, \"-c\" as second argument and name of chosen class as the last argument.");
    }
}
