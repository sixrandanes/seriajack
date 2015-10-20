package com.seriajack.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import com.seriajack.loader.ref.ReferentielLoader;

@Component
@Profile("test")
public class OceanCleaner implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private ReferentielLoader referentielLoader;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        referentielLoader.removeData();
    }

}
