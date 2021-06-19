package games.rednblack;

import com.badlogic.ashley.core.PooledEngine;

public class ConfigAdaptor {

    private final PooledEngine config;

    public ConfigAdaptor(PooledEngine config) {
        this.config = config;
    }

    public void addSystem(SystemAdaptor system) {
        config.addSystem(system.getSystem());
    }

    public EngineAdaptor newEngine() {
        return new EngineAdaptor(config);
    }
}
