package step_definitions;

import pageobjects.AutomationHomePage;
import pageobjects.ProductDetailPage;
import pageobjects.ProductsCatalogPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.When;
import helpers.DataHelper;
import helpers.Log;
import models.Product;
import modules.AddProductToShoppingBacketAction;
import modules.ListProductByNavigationAction;
import modules.ListProductByResearchAction;
import modules.ListProductBySubMenuNavigationAction;
import modules.SelectProductAction;


public class ProductSelectionSteps {
	public WebDriver driver;
	public List<HashMap<String,String>> datamap;

	public ArrayList<Product> list_products ;


	public ProductSelectionSteps()
	{
		driver = Hooks.driver;
		datamap = DataHelper.data();
		list_products = Hooks.list_products;
	}

	@When("^I open zalando website$")
	public void i_open_zalando_website() throws Throwable {
		Log.info("I open zalando website");
		driver.get("http://zalando.es");
	}

	@When("^I search a complement for men by navigation$")
	public void i_search_a_complement_for_men_by_navigation() throws Throwable {
		Log.info("I search a complement for men by navigation");
		
		PageFactory.initElements(driver, AutomationHomePage.class);

		ListProductByNavigationAction.Execute(driver,datamap);
	}
	
	@When("^I search sunglass for men by navigation$")
	public void i_search_sunglass_for_men_by_navigation() throws Throwable {
		Log.info("I search sunglass for men by navigation");
		PageFactory.initElements(driver, AutomationHomePage.class);
		
		ListProductBySubMenuNavigationAction.Execute(driver,datamap);
	}

	@When("^I search bag for women by research$")
	public void i_search_bag_for_women_by_navigation() throws Throwable {

		Log.info("I search bag for women by research");
		PageFactory.initElements(driver, AutomationHomePage.class);

		ListProductByResearchAction.Execute(driver,datamap);
	}

	@When("^I select a product in the list$")
	public void i_select_a_product_in_the_list() throws Throwable {

		Log.info("I select a product in the list");
		PageFactory.initElements(driver, ProductsCatalogPage.class);

		SelectProductAction.Execute(driver,datamap);
	}

	@When("^I add this product to the shopping backet$")
	public void i_add_this_product_to_the_shopping_backet() throws Throwable {

		Log.info("I add this product to the shopping backet");
		
		PageFactory.initElements(driver, ProductDetailPage.class);

		AddProductToShoppingBacketAction.Execute(driver,datamap, list_products );
	}


}
