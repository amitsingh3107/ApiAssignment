package org.example;

import org.apache.commons.io.FileUtils;
import org.example.base.Setup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected Setup setup;
    @BeforeClass
    public void setup(){
        setup = new Setup();
    }
    @BeforeTest
     public void beforeTest() throws IOException {
        FileUtils.copyFile( new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"all_resource.json"),
                               new File(System.getProperty("user.dir")+File.separator+"src"+"target"+File.separator+"classes"+File.separator+"all_resource.json"));
        FileUtils.copyFile( new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"single_resource.json"),
                new File(System.getProperty("user.dir")+File.separator+"src"+"target"+File.separator+"classes"+File.separator+"single_resource.json"));
        FileUtils.copyFile( new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"put_resource.json"),
                new File(System.getProperty("user.dir")+File.separator+"src"+"target"+File.separator+"classes"+File.separator+"put_resource.json"));
    }
}
