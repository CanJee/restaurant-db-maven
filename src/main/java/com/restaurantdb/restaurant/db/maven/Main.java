/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurantdb.restaurant.db.maven;

import java.io.File;
import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;


/**
 *
 * @author Can Jee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String port = System.getenv("PORT");
        GlassFishProperties gfProps = new GlassFishProperties();
        gfProps.setPort("http-listener", Integer.parseInt(port));
        GlassFish glassfish = null;
        try {
            glassfish = GlassFishRuntime.bootstrap().newGlassFish(gfProps);
            glassfish.start();          
            Deployer deployer = glassfish.getDeployer();            
            File file = new File("target/restaurant-db-maven-1.0.war");      
            deployer.deploy(file);
        } catch (Exception e) {}
    }
    
}
