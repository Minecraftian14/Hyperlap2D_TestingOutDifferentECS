package games.rednblack.hyperlap2d.example.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import games.rednblack.hyperlap2d.example.HyperLap2DExampleOnArtemis;
import games.rednblack.hyperlap2d.example.HyperLap2DExampleOnAshley;

import java.io.IOException;
import java.util.Arrays;

/**
 * Launches the desktop (LWJGL3) application.
 */
public class Lwjgl3Launcher {
    public static void main(String[] args)  {
//        JavaProcess.execSeparately(ApplicationLauncherOnArtemis.class, Arrays.asList(args));
//        JavaProcess.execSeparately(ApplicationLauncherOnAshley.class, Arrays.asList(args));
//        ApplicationLauncherOnAshley.main(args);
        ApplicationLauncherOnArtemis.main(args);
    }

    public static Lwjgl3ApplicationConfiguration getDefaultConfiguration(String name) {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("HyperLap2DExample:" + name);
        configuration.setWindowedMode(640, 480);
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        return configuration;
    }
}