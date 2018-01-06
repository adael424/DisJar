import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.JarInputStream;

class FileOpener {

    private FileOpener(){}

    //returns JarInputStream from file in path, or null if a problem occurs
    static JarInputStream createJarInputStream(String pathToFile){
        if(pathToFile.endsWith(".jar")) {
            File file = new File(pathToFile);
            try{
                FileInputStream fileInputStream = new FileInputStream(file);
                return new JarInputStream(fileInputStream);
            }
        catch (FileNotFoundException e) {
                System.out.println("Jar file not found.");
                return null;
            }
        catch (IOException e) {
                System.out.println("Input/Output error occurred, please try again");
                return null;
            }
        }
        else
            System.out.println("Wrong extension of file, please choose file with \".jar\" extension.");
        return null;
    }
}
