package games.rednblack;

import com.badlogic.ashley.core.Entity;

public class EntityAdaptor {

    private final Entity entity;

    public EntityAdaptor(Entity entity) {
        this.entity = entity;
    }

    public <T extends BaseComponent> T getComponent(Class<T> type) {
        return entity.getComponent(type);
    }

    public boolean isRemoving() {
        return entity.isRemoving();
    }

    public boolean isScheduledForRemoval() {
        return entity.isScheduledForRemoval();
    }

    public <T extends BaseComponent> void add(T comp) {
        entity.add(comp);
    }

    public <T extends BaseComponent> void remove(Class<T> clazz) {
        entity.remove(clazz);
    }

    public Entity getEntity() {
        return entity;
    }
}
