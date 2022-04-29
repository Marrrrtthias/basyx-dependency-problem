package com.example.dependecyproblem;

import org.eclipse.basyx.components.configuration.BaSyxContextConfiguration;
import org.eclipse.basyx.components.registry.RegistryComponent;
import org.eclipse.basyx.components.registry.configuration.BaSyxRegistryConfiguration;
import org.eclipse.basyx.components.registry.configuration.RegistryBackend;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class ServerController {

    @PostConstruct
    void init() {
        // assemble paths of AAS Server and Registry
        int registryPort = 4000;
        String registryContextPath = "registry";

        //create RegistryComponent
        BaSyxContextConfiguration registryContextConfig = new BaSyxContextConfiguration(registryPort, registryContextPath);
        BaSyxRegistryConfiguration registryConfig = new BaSyxRegistryConfiguration(RegistryBackend.INMEMORY);
        RegistryComponent registry = new RegistryComponent(registryContextConfig, registryConfig);

        registry.startComponent();
    }

}
