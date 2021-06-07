package com.company.spacetrans.listener;

import com.company.spacetrans.entity.Moon;
import com.company.spacetrans.entity.Spaceport;
import io.jmix.core.DataManager;
import io.jmix.core.Entity;
import io.jmix.core.FluentValueLoader;
import io.jmix.core.FluentValuesLoader;
import io.jmix.core.event.EntityChangedEvent;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component(SpaceportEventListener.NAME)
public class SpaceportEventListener {
    public static final String NAME = "SpaceportEventListener";

    @Autowired
    private DataManager dataManager;

    @Autowired
    private EntityManager entityManager;

    @EventListener
    public void onSpaceportChangedBeforeCommit(EntityChangedEvent<Spaceport> event) {
        Spaceport spaceport = dataManager.load(event.getEntityId()).one();
        if ((spaceport.getMoon() != null && spaceport.getPlanet() != null)||(spaceport.getMoon() == null && spaceport.getPlanet() == null)) {
            throw new RuntimeException("Please select one: Moon OR Planet");
        }
        setDefault(spaceport);
    }

    private void setDefault(Spaceport spaceportEdit){
        if (spaceportEdit.getIsDefault() != null && spaceportEdit.getIsDefault()) {

            List<Spaceport> spaceportList = new ArrayList<>();
            try {
                if (!spaceportEdit.getPlanet().equals(null)) {
                    List<Spaceport> planetDefaultPortsList = (List<Spaceport>) entityManager
                            .createQuery("select s from Spaceport s where s.planet = :planet and s.isDefault <> :is_default")
                            .setParameter("planet", spaceportEdit.getPlanet())
                            .setParameter("is_default", true);

                    if (planetDefaultPortsList.isEmpty()) {
                        spaceportList.addAll(planetDefaultPortsList);
                    }

                }
            }catch (NullPointerException e){

            }catch (ClassCastException e){

            }
            try {
                if (!spaceportEdit.getMoon().equals(null)) {
                    List<Spaceport> moonDefaultPortsList = (List<Spaceport>) entityManager
                            .createQuery("select s from Spaceport s where s.moon = :moon and s.isDefault <> :is_default")
                            .setParameter("moon", spaceportEdit.getMoon())
                            .setParameter("is_default", true);
                    try {
                        if (!moonDefaultPortsList.isEmpty()) {
                            spaceportList.addAll(moonDefaultPortsList);
                        }
                    } catch (QuerySyntaxException e) {

                    }

                }
            }catch (NullPointerException e){

            }catch (ClassCastException e){

            }

            if (!spaceportList.isEmpty()) {
                for (Spaceport spaceportOld : spaceportList) {
                    spaceportOld.setIsDefault(false);
                    entityManager.persist(spaceportOld);
                }
            }
        }
    }
}