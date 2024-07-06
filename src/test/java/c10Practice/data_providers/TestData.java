package c10Practice.data_providers;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"apple", "MacBook"},
			{"microsoft", "SurfaceBook"},
			{"razer", "RazerBook"},
      		{"asus", "ZenBook"},

		};
	}
}