package games.rednblack.hyperrunner.system;

import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;
import games.rednblack.editor.renderer.components.TransformComponent;
import games.rednblack.editor.renderer.components.ViewPortComponent;
import games.rednblack.editor.renderer.utils.ComponentRetriever;

@All(ViewPortComponent.class)
public class CameraSystem extends IteratingSystem {

    private int focus;
    private final float xMin, xMax, yMin, yMax;

    public CameraSystem(float xMin, float xMax, float yMin, float yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    @Override
    protected void process(int entity) {
        ViewPortComponent viewPortComponent = ComponentRetriever.get(entity, ViewPortComponent.class);
        Camera camera = viewPortComponent.viewPort.getCamera();

        if (focus != -1) {
            TransformComponent transformComponent = ComponentRetriever.get(focus, TransformComponent.class);

            if (transformComponent != null) {

                float x = Math.max(xMin, Math.min(xMax, transformComponent.x));
                float y = Math.max(yMin, Math.min(yMax, transformComponent.y + 2));

                camera.position.set(x, y, 0);
            }
        }
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }
}
