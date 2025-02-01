package testng;

import org.testng.annotations.DataProvider;

public class Dataproviderstorlogin {
	@DataProvider(name="logindata")
	public Object [] [] datastorage () {
		
		return new Object [] [] {
			
			{"Admin","admin123"},
			{"Admin","admin@123"},
			{"Anoop","Admin@123"},
			{"Anuj","anoop"}
			
			
				
	};

}
}