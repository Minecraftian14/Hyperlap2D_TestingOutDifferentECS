package games.rednblack.editor.renderer.systems.action.logic;

import games.rednblack.editor.renderer.components.TransformComponent;
import games.rednblack.editor.renderer.systems.action.data.MoveToData;
import games.rednblack.editor.renderer.utils.ComponentRetriever;

/**
 * Created by ZeppLondon on 10/13/2015.
 */
public class MoveToAction<T extends MoveToData> extends TemporalAction<T> {
    @Override
    public void update(float percent, int entity, T actionData) {
        TransformComponent transformComponent = ComponentRetriever.get(entity, TransformComponent.class);

        float x = actionData.startX + (actionData.endX - actionData.startX) * percent;
        float y = actionData.startY + (actionData.endY - actionData.startY) * percent;

        transformComponent.x = x;
        transformComponent.y = y;
    }

    @Override
    public void begin(int entity, T actionData) {
        TransformComponent transformComponent = ComponentRetriever.get(entity, TransformComponent.class);
        actionData.startX = transformComponent.x;
        actionData.startY = transformComponent.y;
    }

    @Override
    public void end(int entity, MoveToData actionData) {

    }
}
