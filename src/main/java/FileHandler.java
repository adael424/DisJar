import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

class FileHandler {
    private final String filePath;
    FileHandler(String filePath){
        this.filePath = filePath;
    }


    LinkedList<Class> getClasses(){
        LinkedList<Class> classes = new LinkedList<>();
        JarInputStream inputStream = FileOpener.createJarInputStream(filePath);
        JarEntry jarEntry;
        URLClassLoader urlClassLoader = createNewUrlClassLoader();
        if (inputStream!=null&&urlClassLoader != null) {
            jarEntry = getNextJarEntry(inputStream);
            while (jarEntry != null) {
                if (jarEntry.getName().endsWith(".class")) {
                    String className = jarEntry.getName().replaceAll("/", "\\.");
                    className = className.substring(0, jarEntry.getName().length() - 6);
                    try {
                        classes.add(urlClassLoader.loadClass(className));
                    } catch (ClassNotFoundException e) {
                        System.out.println("Specified class was not found.");
                        return null;
                    }
                }
                jarEntry = getNextJarEntry(inputStream);
            }
            return classes;
        } else
            return null;
    }

    private void printError(){
        System.out.println("Error reading file classes");
    }

    private JarEntry getNextJarEntry(JarInputStream inputStream){
        try{
            return inputStream.getNextJarEntry();
        } catch(IOException e) {
            printError();
        }
        return null;
    }

    private URLClassLoader createNewUrlClassLoader(){
        URL[] url = new URL[1];
        try {
            url[0] = new URL("jar:file:" + filePath + "!/");
            return new URLClassLoader(url);
        } catch (MalformedURLException e) {
            System.out.println("Error extracting classes occurred.");
            return null;
        }
    }
}
