package com.learning.spring_boot.dynamicallyInitializedbeans.conditionalonproperty;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "debug.tools.enabled", havingValue = "true", matchIfMissing = false)
public class DebugToolsConfig {

    @Bean
    public DebugTools debugTools(){
        if (true){
            throw new RuntimeException("Bean Creation Exception");
        }
        return new DebugTools();
    }

}
