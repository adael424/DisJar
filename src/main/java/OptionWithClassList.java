import java.util.LinkedList;

class OptionWithClassList  {
    LinkedList<Class> createClassesList(String pathToFile){
    FileHandler fileHandle = new FileHandler(pathToFile);
    return fileHandle.getClasses();
}
}
