package sit.int204.classicmodelsservicedemo;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
//    @Bean
//    public ListMapper listMapper(){
//        return ListMapper.getInstance();
//    }
}
