package c10Practice.data_providers;

import org.testng.annotations.DataProvider;

public class TestData2 {
	
	@DataProvider(name="inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"apple"},
			{"microsoft"},
			{"razer"},
      		{"asus"},

		};
	}
}