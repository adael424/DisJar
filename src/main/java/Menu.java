class Menu {
    MenuOption chooseOption(String commands[]){
        if(commands.length == 0){
            return new WrongArgumentsMenuOption();
        }
        else if(commands.length == 1){
            switch (commands[0]){
                case "-h":
                    return new PrintHelpMenuOption();
                default:
                    return new PrintClassesMenuOption();
                }

            }
        else if(commands.length == 3){
            switch (commands[1]){
                case "-i":
                    return new PrintInterfaceImplementationsMenuOption();
                case "-c":
                    return new PrintClassDetailsMenuOption();
                default:
                    return new WrongArgumentsMenuOption();
            }
        }
        else{
            return new WrongArgumentsMenuOption();
        }
    }
}
