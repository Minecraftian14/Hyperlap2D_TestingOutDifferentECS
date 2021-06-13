package games.rednblack.hyperlap2d.example.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import games.rednblack.hyperlap2d.example.HyperLap2DExampleOnArtemis;

public class ApplicationLauncherOnArtemis {
    public static void main(String[] args) {
        new Lwjgl3Application(new HyperLap2DExampleOnArtemis(), getDefaultConfiguration("Artemis"));
    }

    public static Lwjgl3ApplicationConfiguration getDefaultConfiguration(String name) {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("HyperLap2DExample:" + name);
        configuration.setWindowedMode(640, 480);
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        return configuration;
    }
}
