package com.seriajack.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.seriajack.loader.ref.ReferentielLoader;

@Component
@Profile("test")
public class OceanLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ReferentielLoader referentielLoader;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        referentielLoader.loadData();
    }

}
