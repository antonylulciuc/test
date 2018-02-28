package com.revature.mercury;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="./feature/", glue="com.revature.glue",tags= {"@smoke,@regession"})

/**
 * When saying which tags to use in CucumberOptions
 * 	- Excluding tags => "~@tag"
 *  - Must have tags => "@tag1", "@tag2"
 *  - Either or => "@tag1,@tag2"
 * @author Luie
 */
public class CucumberTest {

}
