import org.testng.annotations.Test;

import com.brinyTime.objectRepository.ManageProductPage;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import brinyTimeGenericUtility.BaseClass;

public class Search_Product_Script  extends BaseClass{

	@Test
	public void searchProduct() throws Throwable
	{
		
		wu.takeScreenShot(driver,"MobileScrnSht");

		ManageProductPage manageProduct = new ManageProductPage(driver);
		manageProduct.searchProduct("redmi note 4");
	}
}
