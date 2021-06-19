package games.rednblack;

import com.badlogic.ashley.core.PooledEngine;

public class ECSAdaptor {
    public ConfigAdaptor newConfig(int entityPoolInitialSize, int entityPoolMaxSize, int componentPoolInitialSize, int componentPoolMaxSize) {
        return new ConfigAdaptor(new PooledEngine(entityPoolInitialSize, entityPoolMaxSize, componentPoolInitialSize, componentPoolMaxSize));
    }
}
