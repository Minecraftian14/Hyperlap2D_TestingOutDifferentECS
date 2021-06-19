package games.rednblack;


import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EngineAdaptor {

    private final PooledEngine engine;

    private final ComponentMapper<FNYFYNGComponent> mapper = ComponentMapper.getFor(FNYFYNGComponent.class);

    public EngineAdaptor(PooledEngine engine) {
        this.engine = engine;
    }

    public <T extends BaseComponent> MapperAdaptor<T> getMapper(Class<T> clazz) {
        return new MapperAdaptor<>(ComponentMapper.getFor(clazz));
    }

    public void addEntityListener(EntityListener listener) {
        engine.addEntityListener(new com.badlogic.ashley.core.EntityListener() {
            @Override
            public void entityAdded(Entity entity) {
                listener.entityAdded(mapper.get(entity).getAdaptor());
            }

            @Override
            public void entityRemoved(Entity entity) {
                listener.entityRemoved(mapper.get(entity).getAdaptor());
            }
        });
    }

    public void removeEntity(EntityAdaptor node) {
        engine.removeEntity(node.getEntity());
    }

    public void removeAllEntities() {
        engine.removeAllEntities();
    }

    public void update(float deltaTime) {
        engine.update(deltaTime);
    }

    public <T extends SystemAdaptor> T getSystem(Class<T> systemType) {
        return engine.getSystem(systemType);
    }

    public void addEntity(EntityAdaptor entity) {
        engine.addEntity(entity.getEntity());
    }

    public Iterable<EntityAdaptor> getEntities() {
        return StreamSupport.stream(engine.getEntities().spliterator(), false).map(entity -> mapper.get(entity).getAdaptor()).collect(Collectors.toList());
    }

    public EntityAdaptor createEntity() {
        Entity entity = engine.createEntity();
        FNYFYNGComponent component = new FNYFYNGComponent();
        component.setAdaptor(new EntityAdaptor(entity));
        entity.add(component);
        return component.getAdaptor();
    }

    public <T extends BaseComponent> T createComponent(Class<T> clazz) {
        return engine.createComponent(clazz);
    }

    public <F> F getEnclosed() {
        return null;
    }
}
