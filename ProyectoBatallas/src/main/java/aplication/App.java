package aplication ;

  
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import aplication.persistence.Tablas;
 

 

/**
 * Hello world!
 *
 */


  

@SpringBootApplication
public class App 
{
	
    public static void main( String[] args )
    {
       
    	 //Tablas t = new Tablas();
         //t.crearTablas();
    	
    	 SpringApplication.run(App.class, args);
    	  
    	
    }
    	 
        
}
