package com.company.spacetrans.security;

import com.company.spacetrans.entity.Moon;
import com.company.spacetrans.entity.Planet;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;

@ResourceRole(name = "ReadPlanetRole", code = "readplanetrole")
public interface ReadPlanetRole {

    String CODE = "read-planet-role";

    @EntityAttributePolicy(entityClass = Planet.class, attributes = {"picture", "mass", "name", "semiMajorAxis", "orbitalPeriod", "rotationPeriod", "atmosphere", "rings"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Planet.class, actions = EntityPolicyAction.READ)
    void planet();

    @EntityAttributePolicy(entityClass = Moon.class, attributes = {"planet", "atmosphere", "picture", "mass", "name"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Moon.class, actions = EntityPolicyAction.READ)
    void moon();

    @SpecificPolicy(resources = {"rest.enabled", "rest.uploadCsvFile.enabled"})
    void specify();
}