package com.PFE.StructureRechercheFST.Config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("unused")
@Configuration
public class DTOMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
