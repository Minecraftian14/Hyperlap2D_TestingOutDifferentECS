package games.rednblack;

import com.badlogic.ashley.core.ComponentMapper;

public class MapperAdaptor<A extends BaseComponent> {

    private final ComponentMapper<A> mapper;

    public MapperAdaptor(ComponentMapper<A> mapper) {
        this.mapper = mapper;
    }

    public A get(EntityAdaptor entity) {
        return mapper.get(entity.getEntity());
    }

    public boolean has(EntityAdaptor entity) {
        return mapper.has(entity.getEntity());
    }

    public static <T extends BaseComponent> MapperAdaptor<T> getFor(Class<T> clazz) {
        return new MapperAdaptor<>(ComponentMapper.getFor(clazz));
    }
}
