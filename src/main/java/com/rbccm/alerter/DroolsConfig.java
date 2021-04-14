package com.rbccm.alerter;

import org.drools.compiler.kie.builder.impl.KieBuilderImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

  private KieServices kieServices = KieServices.Factory.get();

  private KieFileSystem getKieFileSystem(){
    KieFileSystem fileSystem = kieServices.newKieFileSystem();
    fileSystem.write(ResourceFactory.newClassPathResource("rules.drl"));
    return fileSystem;
  }

  private KieContainer getKieContainer(){
    getKieRepository();
    KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
    kb.buildAll();
    KieModule module = kb.getKieModule();
    KieContainer container = kieServices.newKieContainer(module.getReleaseId());
    return container;
  }

  private void getKieRepository() {
    KieRepository repository = kieServices.getRepository();
    repository.addKieModule(new KieModule() {
      @Override
      public ReleaseId getReleaseId() {
        return repository.getDefaultReleaseId();
      }
    });
  }

  @Bean
  public KieSession getKieSession(){
    return getKieContainer().newKieSession();
  }

}
