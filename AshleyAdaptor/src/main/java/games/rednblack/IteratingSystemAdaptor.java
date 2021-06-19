/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package games.rednblack;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;

/**
 * A simple EntitySystem that iterates over each entity and calls processEntity() for each entity every time the EntitySystem is
 * updated. This is really just a convenience class as most systems iterate over a list of entities.
 *
 * @author Stefan Bachmann
 */
public abstract class IteratingSystemAdaptor extends EntitySystem {
    private FamilyAdaptor family;
    private Array<EntityAdaptor> entities;

    /**
     * Instantiates a system that will iterate over the entities described by the FamilyAdaptor.
     *
     * @param family The family of entities iterated over in this System
     */
    public IteratingSystemAdaptor(FamilyAdaptor family) {
        this(family, 0);
    }

    /**
     * Instantiates a system that will iterate over the entities described by the FamilyAdaptor, with a specific priority.
     *
     * @param family   The family of entities iterated over in this System
     * @param priority The priority to execute this system with (lower means higher priority)
     */
    public IteratingSystemAdaptor(FamilyAdaptor family, int priority) {
        super(priority);

        this.family = family;
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = new Array<>();
        for (Entity entity : engine.getEntitiesFor(family.get())) {
            entities.add(ComponentMapper.getFor(FNYFYNGComponent.class).get(entity).getAdaptor());
        }
    }

    @Override
    public void removedFromEngine(Engine engine) {
        entities = null;
    }

    @Override
    public void update(float deltaTime) {
        for (int i = 0; i < entities.size; ++i) {
            processEntity(entities.get(i), deltaTime);
        }
    }

    /**
     * @return set of entities processed by the system
     */
    public ImmutableArray<EntityAdaptor> getEntities() {
        return new ImmutableArray<>(entities);
    }

    /**
     * @return the FamilyAdaptor used when the system was created
     */
    public FamilyAdaptor getFamilyAdaptor() {
        return family;
    }

    /**
     * This method is called on every entity on every update call of the EntitySystem. Override this to implement your system's
     * specific processing.
     *
     * @param entity    The current Entity being processed
     * @param deltaTime The delta time between the last and current frame
     */
    protected abstract void processEntity(EntityAdaptor entity, float deltaTime);
}
