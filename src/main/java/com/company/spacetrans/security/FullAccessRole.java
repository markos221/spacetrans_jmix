package com.company.spacetrans.security;

import com.company.spacetrans.entity.*;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;

@ResourceRole(name = "Full Access", code = FullAccessRole.CODE)
public interface FullAccessRole {

    String CODE = "system-full-access";

    @EntityPolicy(entityName = "*", actions = {EntityPolicyAction.ALL})
    @SpecificPolicy(resources = {"*", "rest.fileUpload.enabled", "rest.fileDownload.enabled", "rest.enabled", "rest.uploadCsvFile.enabled", "ui.loginToUi", "datatools.ui.showEntityInfo", "cuba.gui.bulkEdit", "ui.filter.modifyJpqlCondition", "ui.filter.modifyConfiguration", "cuba.gui.presentations.global", "cuba.gui.showExceptionDetails", "ui.filter.modifyGlobalConfiguration"})
    void fullAccess();

    @EntityAttributePolicy(entityClass = AstronomicalBody.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = AstronomicalBody.class, actions = EntityPolicyAction.ALL)
    void astronomicalBody();

    @EntityAttributePolicy(entityClass = Atmosphere.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Atmosphere.class, actions = EntityPolicyAction.ALL)
    void atmosphere();

    @EntityAttributePolicy(entityClass = AtmosphericGas.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = AtmosphericGas.class, actions = EntityPolicyAction.ALL)
    void atmosphericGas();

    @EntityAttributePolicy(entityClass = Carrier.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Carrier.class, actions = EntityPolicyAction.ALL)
    void carrier();

    @EntityAttributePolicy(entityClass = Company.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Company.class, actions = EntityPolicyAction.ALL)
    void company();

    @EntityAttributePolicy(entityClass = Coordinates.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Coordinates.class, actions = EntityPolicyAction.ALL)
    void coordinates();

    @EntityAttributePolicy(entityClass = Customer.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Customer.class, actions = EntityPolicyAction.ALL)
    void customer();

    @EntityAttributePolicy(entityClass = Dimensions.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Dimensions.class, actions = EntityPolicyAction.ALL)
    void dimensions();

    @EntityAttributePolicy(entityClass = Discounts.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Discounts.class, actions = EntityPolicyAction.ALL)
    void discounts();

    @EntityAttributePolicy(entityClass = Gas.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Gas.class, actions = EntityPolicyAction.ALL)
    void gas();

    @EntityAttributePolicy(entityClass = Individual.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Individual.class, actions = EntityPolicyAction.ALL)
    void individual();

    @EntityAttributePolicy(entityClass = Moon.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Moon.class, actions = EntityPolicyAction.ALL)
    void moon();

    @EntityAttributePolicy(entityClass = Planet.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Planet.class, actions = EntityPolicyAction.ALL)
    void planet();

    @EntityAttributePolicy(entityClass = Spaceport.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Spaceport.class, actions = EntityPolicyAction.ALL)
    void spaceport();

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.ALL)
    void user();

    @EntityAttributePolicy(entityClass = Waybill.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Waybill.class, actions = EntityPolicyAction.ALL)
    void waybill();

    @EntityAttributePolicy(entityClass = WaybillItem.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = WaybillItem.class, actions = EntityPolicyAction.ALL)
    void waybillItem();
}