package games.rednblack.hyperrunner.system;

import com.artemis.annotations.All;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.physics.box2d.Body;
import games.rednblack.editor.renderer.components.ParentNodeComponent;
import games.rednblack.editor.renderer.components.TransformComponent;
import games.rednblack.editor.renderer.components.physics.PhysicsBodyComponent;
import games.rednblack.editor.renderer.components.sprite.SpriteAnimationComponent;
import games.rednblack.editor.renderer.components.sprite.SpriteAnimationStateComponent;
import games.rednblack.editor.renderer.utils.ComponentRetriever;
import games.rednblack.hyperrunner.component.PlayerComponent;

@All(PlayerComponent.class)
public class PlayerAnimationSystem extends IteratingSystem {

    @Override
    protected void process(int entity) {
        ParentNodeComponent nodeComponent = ComponentRetriever.get(entity, ParentNodeComponent.class);
        Body body = ComponentRetriever.get(nodeComponent.parentEntity, PhysicsBodyComponent.class).body;

        PlayerComponent playerComponent = ComponentRetriever.get(entity, PlayerComponent.class);
        SpriteAnimationComponent spriteAnimationComponent = ComponentRetriever.get(entity, SpriteAnimationComponent.class);
        SpriteAnimationStateComponent spriteAnimationStateComponent = ComponentRetriever.get(entity, SpriteAnimationStateComponent.class);
        TransformComponent transformComponent = ComponentRetriever.get(entity, TransformComponent.class);

        if (Math.abs(body.getLinearVelocity().x) > 0.1f) {
            spriteAnimationComponent.playMode = Animation.PlayMode.LOOP;

            spriteAnimationComponent.currentAnimation = "run";
            spriteAnimationComponent.fps = Math.max(6, (int) Math.abs(body.getLinearVelocity().x) * 3);

            transformComponent.flipX = body.getLinearVelocity().x < 0;
        } else if (playerComponent.touchedPlatforms > 0) {
            spriteAnimationComponent.playMode = Animation.PlayMode.LOOP;

            spriteAnimationComponent.currentAnimation = "idle";
        }

        if (body.getLinearVelocity().y > 0.2f) {
            spriteAnimationComponent.currentAnimation = "jumpUp";
            spriteAnimationComponent.playMode = Animation.PlayMode.NORMAL;
        } else if (body.getLinearVelocity().y < -0.2f) {
            spriteAnimationComponent.currentAnimation = "jumpUp";
            spriteAnimationComponent.playMode = Animation.PlayMode.REVERSED;
        }

        spriteAnimationStateComponent.set(spriteAnimationComponent);
    }
}
