package com.backendapiproject.searchandservice.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    ModelMapper modelMapper() {
        var mapper =  new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setCollectionsMergeEnabled(true);
        mapper.getConfiguration().setFieldMatchingEnabled(true);
        return mapper;
    }

}
