package games.rednblack.hyperlap2d.example.lwjgl3;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class JavaProcess {

    /**
     * https://stackoverflow.com/a/723914/2016436
     */
    private JavaProcess() {}


    public static void execSeparately(Class klass, List<String> args){
        new Thread(() -> {
            try {
                exec(klass, args);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static int exec(Class klass, List<String> args) throws IOException,
            InterruptedException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome +
                File.separator + "bin" +
                File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = klass.getName();

        List<String> command = new LinkedList<String>();
        command.add(javaBin);
        command.add("-cp");
        command.add(classpath);
        command.add(className);
        if (args != null) {
            command.addAll(args);
        }

        ProcessBuilder builder = new ProcessBuilder(command);

        Process process = builder.inheritIO().start();
        process.waitFor();
        return process.exitValue();
    }

}
