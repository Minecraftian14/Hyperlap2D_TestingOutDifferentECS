package games.rednblack.hyperlap2d.example.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import games.rednblack.hyperlap2d.example.HyperLap2DExampleOnAshley;

import static games.rednblack.hyperlap2d.example.lwjgl3.Lwjgl3Launcher.getDefaultConfiguration;

public class ApplicationLauncherOnAshley {
    public static void main(String[] args) {
        new Lwjgl3Application(new HyperLap2DExampleOnAshley(), getDefaultConfiguration("Ashley"));
    }
}
