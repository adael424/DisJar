

public class WrongArgumentsMenuOption implements MenuOption {
    public void execute(String[] commands) {
        System.out.println("Input \"-h\" as the first and only argument to get help");
    }
}
