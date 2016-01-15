package step_definitions;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import implementation.Checkout;
import static org.junit.Assert.*;

public class CheckoutSteps {
	
	Checkout checkout = new Checkout();
	int applePrice = 0;
	int bananaPrice = 0;

    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void thePriceOfAIsC(String name, int price) throws Throwable {
		if (name.equals("apple")) {
			applePrice = price;
		} else if (name.equals("banana")) {
			bananaPrice = price;
		}
    }

    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void iCheckout(int itemCount, String itemName) throws Throwable {
		if (itemName.equals("apple")) {
			checkout.add(itemCount, applePrice);
		} else if (itemName.equals("banana")) {
			checkout.add(itemCount, bananaPrice);
		}
    }

    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) throws Throwable {
        assertEquals(total, checkout.total());
    }
}