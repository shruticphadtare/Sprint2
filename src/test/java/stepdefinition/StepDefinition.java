package stepdefinition;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hooks.Hookclass;

public class StepDefinition {
	
		//WebDriver driver;
		WebDriver driver=Hookclass.driver;
	
		@Given("user is on login page")
		public void user_is_on_login_page() {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			//driver = new ChromeDriver();
			driver.get("http://realty-real-estatem1.upskills.in/my-profile/");
			driver.manage().window().maximize();
			}

		@When("Admin will enter userId {string} and password {string}")
		public void admin_will_enter_userId_and_password(String userId, String password) {
			try {
				driver.findElement(By.id("user_login")).sendKeys(userId);
				driver.findElement(By.id("user_pass")).sendKeys(password);
			} 
			catch (Exception e) {
				System.out.println("Admin is unable to login"+e);
				Assert.fail();
			}
	}	

		@And("Admin will click on sign in tab")
		public void admin_will_click_on_sign_in_tab() {
			try {
				driver.findElement(By.name("login")).click();
				} 
			catch (Exception e) {
				System.out.println("Admin is unable to click on sign in tab"+e);
				Assert.fail();
		}

	}

		@Then("Admin will be navigated to Real Estate dashboard")
		public void admin_will_be_navigated_to_Real_Estate_dashboard() {
			try {
				String expectedtitle= "Dashboard ‹ Real Estate — WordPress";
				String actualTitle=driver.getTitle();
				Assert.assertEquals(expectedtitle,actualTitle );
				System.out.println("Title of real estate dashboard is "+actualTitle);
				System.out.println("----------------------------");
			} 
			 catch (Exception e) {
				System.out.println("Admin is not able to navigate to dashborad");
				Assert.fail();
			 }
	}

	
	  @And("Admin will hover the mouse over media section and click on library")
	  public void
	  admin_will_hover_the_mouse_over_media_section_and_click_on_library(){ 
		  try {
			  WebElement Media= driver.findElement(By.xpath("//li[@id='menu-media']"));  
			  Actions actions = new Actions(driver);                         			 
			  actions.moveToElement(Media); 										
			  Thread.sleep(2000);
	  
	  
			  WebElement library=driver.findElement(By.xpath("//li[@id='menu-media']/a/div[3]")); 	
			  actions.moveToElement(library); 															
			  actions.click().build().perform(); 
		  	}
	  
		  catch (Exception e) {
			  System.out.println("Admin is not able to hover over media section"+e);
			  Assert.fail(); }
	  
	  }
	  
	  
	
	  @Then("Admin will be able to see media library") 
	  public void admin_will_be_able_to_see_media_library() { 
		  try { 
			  String expectedtitle="Media Library ‹ Real Estate — WordPress"; 
			  String actualTitle=driver.getTitle();
			  Assert.assertEquals(expectedtitle,actualTitle);
			  System.out.println("Actual Title: "+actualTitle);
			  System.out.println("----------------------------"); }
	  
		  catch (Exception e) {
			  System.out.println("Admin is not able to see media library"); 
			  Assert.fail();
		  	}
		 }
	 
	 
	  @Given("admin will hover over media section and click on Add New tab")
	  public void admin_will_hover_over_media_section_and_click_on_Add_New_tab() {
		  try {
			
				WebElement Media= driver.findElement(By.xpath("//li[@id='menu-media']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(Media);
				Thread.sleep(3000);

				WebElement addnew= driver.findElement(By.linkText("Add New"));
				actions.moveToElement(addnew);
				Thread.sleep(2000);
				actions.click().build().perform();
				Thread.sleep(3000);
			} 
		  
		  catch (Exception e) {
				System.out.println("Admin is not able to hover over media section"+e);
				Assert.fail();
			}
	  }

	
	  
	   	@And("Admin will navigates to upload new media webpage")
	   	public void admin_will_navigates_to_upload_new_media_webpage() {
	   		try {
				String expectedtitle= "Upload New Media ‹ Real Estate — WordPress";
				String actualTitle=driver.getTitle();
				Assert.assertEquals(expectedtitle,actualTitle );
				System.out.println("Actual Title of upload new media webpage: "+actualTitle); 
				System.out.println("----------------------------");
	   			} 
		 catch (Exception e) {
			 	System.out.println("Admin is not able to navigate to upload new media webpage");
			 	Assert.fail();
		 }
	}
	
	   	@Then("admin verifies the choose file field")
	   	public void admin_verifies_the_choose_file_field() {
	   	    try {
				Boolean b=driver.findElement(By.xpath("//*[@id='async-upload']")).isDisplayed();
				System.out.println("Choose file field is present: "+b);
				System.out.println("----------------------------");
			} catch (Exception e) {
				System.out.println("Choose field file is not present"+e);
				Assert.fail();
			}
	   	}
	   
	   
	   @Given("Admin is on media media library webpage")
	   public void admin_is_on_media_media_library_webpage() {
		   try { 
			   String expectedtitle="Media Library ‹ Real Estate — WordPress"; 
			   String actualTitle=driver.getTitle(); 
			   Assert.assertEquals(expectedtitle,actualTitle);
			   System.out.println("Actual Title of media library webpage"+actualTitle);
			   System.out.println("----------------------------");
			   } 
		   catch (Exception e) {
			   System.out.println("Admin is not able to see media library"+e); 
			   Assert.fail();
		   	} 
	    
	}

	
	   @When("Admin will click on all media item dropdown menu and select images option") 
	   public void admin_will_click_on_all_media_item_dropdown_menu_and_select_images_option() {
		   try { 
			   		Select mediaitem = new Select(driver.findElement(By.id("attachment-filter")));
			   		mediaitem.selectByVisibleText("Images");
			   		Thread.sleep(1000); 
		   		} 
	  
		   catch (Exception e) {
			   	System.out.println("Admin is not able to click on dropdown menu"+e); 
			   	Assert.fail();
		   	}
	  }
	  

	   @And("admin will click on all dates dropdown menu and select first option")
	   public void admin_will_click_on_all_dates_dropdown_menu_and_select_first_option()  {
		   try { 
			   Select date = new Select(driver.findElement(By.id("filter-by-date")));
			   date.selectByVisibleText("October 2021"); 
			   Thread.sleep(1000);
			   } 
		   catch (Exception e){ 
			   System.out.println("Admin is not able to select first option"+e); 
			   Assert.fail();
		   } 
	  }
 
	
	   @And("admin will click on filter tab and admin will get total items after first filteration")
	   public void admin_will_click_on_filter_tab_and_admin_will_get_total_items_after_first_filteration() {
		   	try {
		   		driver.findElement(By.id("post-query-submit")).click();
		   		String items= driver.findElement(By.className("displaying-num")).getText();
		   		System.out.println("Number of items: " +items);
		   		System.out.println("----------------------------");
		   		} 
		   	catch (Exception e) {
		   		System.out.println("Admin is not able to click on filter tab"+e);
		   		Assert.fail();
		}
		  
	  }	  

	


	   @And("admin will click on all dates dropdown menu and select second option")
	   public void admin_will_click_on_all_dates_dropdown_menu_and_select_second_option_and_clicks_on_filter_tab() {
		   	try {
		   		Select date = new Select(driver.findElement(By.id("filter-by-date")));
		   		date.selectByVisibleText("September 2021");
		   		Thread.sleep(1000);
		   		} 
		   	catch (Exception e) {
		   		System.out.println("Admin is not able to select second option"+e);
		   		Assert.fail();
		}
	}
	
	   
	   @And("admin will click on filter tab and admin will get total items after second filteration")
	   public void admin_will_click_on_filter_tab_and_admin_will_get_total_items_after_second_filteration() {
		   	try {
				driver.findElement(By.id("post-query-submit")).click();
				String items= driver.findElement(By.className("displaying-num")).getText();
				System.out.println("Number of items: " +items);
				System.out.println("----------------------------");
		   		} 
		   	catch (Exception e) {
				System.out.println("Admin is not able to click on filter tab"+e);
				Assert.fail();
			}
			  
		  }	  
	   
	
	   @And("admin will click on all dates dropdown menu and select fourth option")
	   public void admin_will_click_on_all_dates_dropdown_menu_and_select_fourth_option() {
		   try {
			   Select date = new Select(driver.findElement(By.id("filter-by-date")));
			   date.selectByVisibleText("December 2018");
			   Thread.sleep(1000);
		   		} 
		   catch (Exception e) {
			   System.out.println("Admin is not able to select fourth option"+e);
			   Assert.fail();
		   	}
	}
	
	
	   @And("admin clicks on filter tab and admin will get total items after fourth filteration")
	   public void admin_clicks_on_filter_tab_and_admin_will_get_total_items_after_fourth_filteration() {
		   try {
			   driver.findElement(By.id("post-query-submit")).click();
			   String items= driver.findElement(By.className("displaying-num")).getText();
			   System.out.println("Number of items: " +items);
			   System.out.println("----------------------------");
		   		} 
		   catch (Exception e) {
			   System.out.println("Admin is not able to click on filter tab"+e);
			   Assert.fail();
		}
	}
		 
	
	   @When("Admin will click on all media item dropdown menu and select unattached option")
	   public void admin_will_click_on_all_media_item_dropdown_menu_and_select_unattached_option() {
		   try {
			   Select mediaitem = new Select(driver.findElement(By.id("attachment-filter")));
			   mediaitem.selectByVisibleText("Unattached");
			   Thread.sleep(1000);
		   		} 
		   catch (Exception e) {
			   System.out.println("Admin is not able to click on dropdown menu"+e); 
			   Assert.fail();
		}
	}
	
	
	   @And("admin will click on all dates dropdown menu again and select first option")
	   public void admin_will_click_on_all_dates_dropdown_menu_again_and_select_first_option() {
		   try {
			   Select date = new Select(driver.findElement(By.id("filter-by-date")));
			   date.selectByVisibleText("October 2021");
			   Thread.sleep(1000);
		   		} 
		   catch (Exception e) {
			   	System.out.println("Admin is not able to select first option"+e);
			   	Assert.fail();
		   }
	}	
	
	
	   @And("admin clicks on filter tab and admin will get total items after fifth filteration")
	   public void admin_clicks_on_filter_tab_and_admin_will_get_total_items_after_fifth_filteration() {
		   try {
			   driver.findElement(By.id("post-query-submit")).click();
			   String items= driver.findElement(By.className("displaying-num")).getText();
			   System.out.println("Number of items: " +items);
			   System.out.println("----------------------------");
		   		}
		   catch (Exception e) {
			   System.out.println("Admin is not able to click on filter tab"+e);
			   Assert.fail();
		}
	}
	
	
	   @And("admin will click on all dates dropdown menu again and select second option")
	   public void admin_will_click_on_all_dates_dropdown_menu_again_and_select_second_option(){
		   try {
			   Select date = new Select(driver.findElement(By.id("filter-by-date")));
			   date.selectByVisibleText("September 2021");
			   Thread.sleep(1000);
			
		   		} 
		   catch (Exception e) {
			   	System.out.println("Admin is not able to select second option"+e);
			   	Assert.fail();
		}
	}
	   
	   
	   @And("clicks on filter tab and admin will get total items after sixth filteration")
	   public void clicks_on_filter_tab_and_admin_will_get_total_items_after_sixth_filteration() {
		   try {
			   driver.findElement(By.id("post-query-submit")).click();
			   String items= driver.findElement(By.className("displaying-num")).getText();
			   System.out.println("Number of items: " +items);
			   System.out.println("----------------------------");
		   		} 
		   catch (Exception e) {
			System.out.println("Admin is not able to click on filter tab"+e);
			Assert.fail();
		}
	}
		
	
		@And("admin will click on all dates dropdown menu again and select fourth option")
		public void admin_will_click_on_all_dates_dropdown_menu_again_and_select_fourth_option() {
			try {
				Select date = new Select(driver.findElement(By.id("filter-by-date")));
				date.selectByVisibleText("December 2018");
				Thread.sleep(1000);
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to select fourth option"+e);
				Assert.fail();
		}
	  
	}

		@And("admin clicks on filter tab and admin will get total items after eight filteration")
		public void admin_clicks_on_filter_tab_and_admin_will_get_total_items_after_eight_filteration() {
			try {
				driver.findElement(By.id("post-query-submit")).click();
				String items= driver.findElement(By.className("displaying-num")).getText();
				System.out.println("Number of items: " +items);
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to click on filter tab"+e);
				Assert.fail();
		}
	}
	
		@Given("Admin will click on bulk action tab and selects delete permanently choice")
		public void Admin_will_click_on_bulk_action_tab_and_selects_delete_permanently_choice() {
			try {
				Select bulkaction = new Select(driver.findElement(By.id("bulk-action-selector-top")));
				bulkaction.selectByVisibleText("Delete Permanently");
				Thread.sleep(2000);
				System.out.println("Admin is able to click on bulk action dropdown and is able to select delete permanently option");
				System.out.println("----------------------------");
				}
			catch (Exception e) {
				System.out.println("Admin is not able to click on bulk action"+e); 
				Assert.fail();
		}
	}

		@And("Admin will select checkbox available in front of image")
		public void admin_will_select_checkbox_available_in_front_of_image() {
			try {
				driver.findElement(By.id("cb-select-11773")).click();
				System.out.println("Admin is able to select checkbox");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
					System.out.println("Admin is not able to select checkbox"+e);
					Assert.fail();
				}
	}

	
		@Then("Admin will click on apply button")
		public void admin_will_click_on_apply_button()  {
			try {
				driver.findElement(By.xpath("//*[@id='doaction']")).click();
				Thread.sleep(1000);
				System.out.println("Admin is able to click on apply button");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to click on apply button"+e);
				Assert.fail();
			}
	}

		@Then("alert message will display")
		public void alert_message_will_display() {
			try {
					Alert alert=driver.switchTo().alert();     
					String alertMessage= alert.getText();								// Capturing alert message	
					System.out.println(alertMessage);  									// Displaying alert message	
					System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Alert message not displayed"+e);
				Assert.fail();
		}
		
	}

		@And("admin will dismiss the action")
		public void admin_dismiss_the_action() {
				try {
					Alert alert=driver.switchTo().alert(); 
					alert.dismiss();
					System.out.println("Admin dismiss the alert message");
					System.out.println("----------------------------");
					}
				catch (Exception e) {
					System.out.println("Admin is not able to dismiss the alert message"+e);
					Assert.fail();
				
				}
		}

		@And("admin will refresh the page")
		public void admin_refresh_the_page() {
			try {
				driver.navigate().refresh();
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to refresh the page");
				Assert.fail();
		}
	}

		
		@Given("Admin will hover the mouse over media section and admin will select library from dropdown")
		public void admin_will_hover_the_mouse_over_media_section_and_admin_will_select_library_from_dropdown() {
			try {
		
				WebElement Media= driver.findElement(By.xpath("//li[@id='menu-media']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(Media);
				Thread.sleep(2000);
			
				WebElement library= driver.findElement(By.xpath("//li[@id='menu-media']/a/div[3]"));
				actions.moveToElement(library);
				actions.click().build().perform();
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to hover over media section"+e);
				Assert.fail();
			}

	}




		@And("admin will enter {string} in search media items field and clicks on enter key")
		public void admin_will_enter_in_search_media_items_field_and_clicks_on_enter_key(String data) {
			try {
				WebElement search=driver.findElement(By.id("media-search-input"));
				Thread.sleep(2000);
				search.sendKeys(data);
				search.sendKeys(Keys.ENTER);
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to enter data in the search field"+e);
				Assert.fail();
			}
	}
		
	
		@Then("admin verifies message displayed on the screen")
		public void admin_verifies_message_displayed_on_the_screen() {
			try {
				String expectedtext1=driver.findElement(By.xpath("//*[@id='wpbody-content']/div[3]/span")).getText();
				String actualtext1="Search results for “apartment”";
				Assert.assertEquals(expectedtext1,actualtext1);
				System.out.println("Result of search message is: "+expectedtext1);
				System.out.println("----------------------------");
			} 
			catch (Exception e) {
				System.out.println("Result of search message is not displayed on the screen"+e);
				Assert.fail();
		}
	}


	

		@And("admin will check the availability of items according to search")
		public void admin_will_check_the_availability_of_items_according_to_search() {
			try {
				String str=driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/div[2]/div[2]/span[1]")).getText();
				System.out.println("Available items according to search: "+str);
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to get the text"+e);
				Assert.fail();
		}
	}


		@Given("admin will refresh the page first")
		public void admin_will_refresh_the_page_first() {
			try {
				driver.navigate().refresh();
				} 
			catch (Exception e) {
					System.out.println("Admin is not able to refresh the page");
					Assert.fail();
				}
}


		@When("admin will hover the mouse over media section and click on library option")
		public void admin_will_hover_the_mouse_over_media_section_and_click_on_library_option() {
			try {
		
				WebElement Media= driver.findElement(By.xpath("//li[@id='menu-media']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(Media);
				Thread.sleep(2000);

				WebElement library= driver.findElement(By.xpath("//li[@id='menu-media']/a/div[3]"));
				actions.moveToElement(library); 
				actions.click().build().perform();
				} 
		catch (Exception e) {
				System.out.println("Admin is not able to hover over media section"+e);
				Assert.fail();
			}
}
		

		@And("admin will click on screen options button")
		public void admin_will_click_on_screen_options_button() {
			try {
				driver.findElement(By.xpath("//*[@id='show-settings-link']")).click();
				Thread.sleep(3000);
				System.out.println("Admin is able to click on screen options tab");
				System.out.println("----------------------------");
				}	
			catch (Exception e) {
					System.out.println("Admin is unable to click on screen options button"+e);
					Assert.fail();
				}
	}
	
		@Then("admin deselects all the checkbox") 
		public void admin_deselects_all_the_checkbox() throws InterruptedException {
			try {
				driver.findElement(By.id("author-hide")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("parent-hide")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("comments-hide")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("date-hide")).click();
				Thread.sleep(1000);
				System.out.println("Admin deselects all the checkbox");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to deselect the checkbox");
				Assert.fail();
				}
		  
	  }
	  


		@When("admin clicks on author checkbox")
		public void admin_clicks_on_author_checkbox() {
			try {
				boolean x=driver.findElement(By.id("author-hide")).isSelected();
				if(x==false)
			   	driver.findElement(By.id("author-hide")).click();
				Thread.sleep(1000);
				System.out.println("Admin is able to click on author checkbox");
				System.out.println("----------------------------");
				} 	
			catch (Exception e) {
				System.out.println("Admin is not able to select the author checkbox");
				Assert.fail();
			}
	}

		@Then("author column gets appeared in the media table")
		public void author_column_gets_appeared_in_the_media_table() {
			try {
				String expectedtext1=driver.findElement(By.xpath("//*[@id='author']/a/span[1]")).getText();
				String actualtext1="Author";
				Assert.assertEquals(expectedtext1,actualtext1);
				System.out.println("Author column is present in media table");
				System.out.println("----------------------------");
				} 	
			catch (Exception e) {
				System.out.println("author column is not present"+e);
				Assert.fail();
			}
	}

		@When("admin clicks on uploaded to checkbox")
		public void admin_clicks_on_uploaded_to_checkbox() {
			try {
				boolean x=driver.findElement(By.id("parent-hide")).isSelected();
				if(x==false)
				driver.findElement(By.id("parent-hide")).click();
				Thread.sleep(1000);
				System.out.println("Admin is able to click on uploaded to checkbox");
				System.out.println("----------------------------");
					
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to select the author checkbox");
				Assert.fail();
			}
	}

		@Then("uploaded to column gets appeared in the media table")
		public void uploaded_to_column_gets_appeared_in_the_media_table() {
			try {
				String expectedtext2=driver.findElement(By.xpath("//*[@id='parent']/a/span[1]")).getText();
				String actualtext2="Uploaded to";
				Assert.assertEquals(expectedtext2,actualtext2);
				System.out.println("uploaded to column is present in media table");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("uploaded to column is not present"+e);
				Assert.fail();
			}
}

		@When("admin clicks on comments checkbox")
		public void admin_clicks_on_comments_checkbox() {
			try {
				boolean x=driver.findElement(By.id("comments-hide")).isSelected();
				if(x==false)
				driver.findElement(By.id("comments-hide")).click();
				Thread.sleep(1000);
				System.out.println("Admin is able to click on comment checkbox");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to select the author checkbox");
				Assert.fail();
			}
	}

	
		@Then("comments column gets appeared in the media table")
		public void comments_column_gets_appeared_in_the_media_table() {
			try {
				String expectedtext3=driver.findElement(By.xpath("//*[@id='comments']/a/span[1]/span")).getText();
				String actualtext3="Comments";
				Assert.assertEquals(expectedtext3,actualtext3);
				System.out.println("comments column is present in media table");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("comments column is not present"+e);
				Assert.fail();
			}
}

		@When("admin clicks on date checkbox")
		public void admin_clicks_on_date_checkbox() {
			try {
				boolean x=driver.findElement(By.id("date-hide")).isSelected();
				if(x==false)
				driver.findElement(By.id("date-hide")).click();
				Thread.sleep(1000);
				System.out.println("Admin is able to click on date checkbox");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to select the author checkbox");
				Assert.fail();
			}
	}

		@Then("date column gets appeared in the media table")
		public void date_column_gets_appeared_in_the_media_table() {
			try {
				String expectedtext4=driver.findElement(By.xpath("//*[@id='date']/a/span[1]")).getText();
				String actualtext4="Date";
				Assert.assertEquals(expectedtext4,actualtext4);
				System.out.println("date column is present in media table");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("date column is not present"+e);
				Assert.fail();
				}
}
		
		@And("admin checks total column and fetch column names from the media table")
		public void admin_checks_total_column_and_fetch_column_names_from_the_media_table(){
				
				try {
					int totalcolumn = driver.findElements(By.xpath("//*[@id=\"posts-filter\"]/table/thead/tr[1]/th")).size();
					System.out.println("Total number of columns = " + totalcolumn);

					WebElement element = driver.findElement(By.xpath("//*[@id=\"posts-filter\"]/table"));
					List<WebElement> row = element.findElements(By.tagName("tr"));
					List<WebElement> colHeader = row.get(0).findElements(By.tagName("th"));
					
					for(int i=0; i<colHeader.size(); i++){
						System.out.println(colHeader.get(i).getText());
						System.out.println("----------------------------");
						}
					} 
				catch (Exception e) {
					System.out.println("Admin is not able to get toatl column and column headers"+e);
					Assert.fail();
				}
		}
		
				
		@And("admin fetch first ten existing records")
		public void admin_fetch_first_ten_existing_records() {
			
			try {
				for(int i=2; i<=10; i++){
					for(int j=1; j<=4; j++){
						System.out.print(driver.findElement(By.xpath("//*[@id='the-list']/tr["+i+"]/td["+j+"]")).getText());
						System.out.println(" ");
						}
					}
				} 
			catch (Exception e) {
					System.out.println("Admin is not able to fetch records"+e);
					Assert.fail();
			}
		}
		


		@Given("Admin will hover the mouse over media section and selects library option from dropdown")
		public void admin_will_hover_the_mouse_over_media_section_and_selects_library_option_from_dropdown() {
			try {
				WebElement Media= driver.findElement(By.xpath("//li[@id='menu-media']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(Media);
				Thread.sleep(3000);

				WebElement library= driver.findElement(By.xpath("//li[@id='menu-media']/a/div[3]"));
				actions.moveToElement(library);
				actions.click().build().perform();
			} 
		catch (Exception e) {
			System.out.println("Admin is not able to hover over media section"+e);
			Assert.fail();
		}
	}
	
		@And("admin will click on screen options button present on upper right corner of the webpage")
		public void admin_will_click_on_screen_options_button_present_on_upper_right_corner_of_the_webpage() {
			try {
				driver.findElement(By.xpath("//*[@id='show-settings-link']")).click();
				Thread.sleep(1000);
				}	
		catch (Exception e) {
			System.out.println("Admin is unable to click on screen options button"+e);
			Assert.fail();
		}
	  
	}

	
	
		@And("admin will enter {string} in Number of items per page: field")
		public void admin_will_enter_in_Number_of_items_per_page_field(String count) {
			try {
				driver.findElement(By.id("upload_per_page")).clear();
				Thread.sleep(2000);
				driver.findElement(By.id("upload_per_page")).sendKeys(count);
				Thread.sleep(2000);
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to see number of items per page field"+e);
				Assert.fail();
			}
	}
	

		@And("then clicks on apply button")
		public void then_clicks_on_apply_button() {
			try {
				driver.findElement(By.id("screen-options-apply")).click();
				Thread.sleep(2000);
				} 	
			catch (Exception e) {
				System.out.println("Admin is not able to click on apply button"+e);
				Assert.fail();
			}
}

	
		@And("admin checks if pagination exists or not")
		public void admin_checks_if_pagination_exists_or_not() {
		
			try {
				List<WebElement>pagination =driver.findElements(By.xpath("//*[@id='posts-filter']/div[2]/div[2]/span[2]"));
				if(pagination.size()>0)																							// check if pagination link exists 
					{ 
					System.out.println("pagination exists"); 
					System.out.println("----------------------------");

				for(int i=0; i<pagination.size(); i++)         																	 // click on pagination link 
					{ 
					 	pagination.get(i).click();
					} 
					} 
				else 
					{ 
					System.out.println("pagination not exists"); 
					}
			} catch (Exception e) {
				System.out.println("Admin is not able check pagination exists or not"+e);
			}
		}
		



		@Then("admin will get current page according to filter") 
		public void admin_will_get_current_page_according_to_filter() { 
			try { 
				String Currentpage=driver.findElement(By.xpath("//*[@id='table-paging']/span")).getText(); 
				System.out.println("Current page is: "+Currentpage); 
				System.out.println("----------------------------");
				} 
			catch(Exception e) {
				System.out.println("Admin is not able to get current page"+e); 
				Assert.fail();
			} 
		}
  
		@And("admin clicks on next page button and navigates to second page") 
		public void admin_clicks_on_next_page_button_and_navigates_to_second_page() { 
			try {
				WebElement nextpage= driver.findElement(By.xpath("//*[@id='posts-filter']/div[2]/div[2]/span[2]/a[1]")); 
				nextpage.click();
				Thread.sleep(2000); 
				System.out.println("Admin is on the second page");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to click on next page"+e); 
				Assert.fail();
			}
		}
  
		@And("admin clicks on last page button and navigates to last page")
		public void admin_clicks_on_last_page_button_and_navigates_to_last_page() { 
			try {
				WebElement lastpage= driver.findElement(By.xpath("//*[@id='posts-filter']/div[2]/div[2]/span[2]/a[3]")); 
				lastpage.click();
				Thread.sleep(2000); 
				System.out.println("Admin is on the last page");
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to navigate on last page"+e);
				Assert.fail();
			}
		}



		@And("then admin will navigate to first page using")
		public void then_admin_will_navigate_to_first_page_using() {
			try {
				WebElement firstpage= driver.findElement(By.xpath("//*[@id='posts-filter']/div[2]/div[2]/span[2]/a[1]"));
				firstpage.click();
				Thread.sleep(2000);
				} 
			catch (Exception e) {
				System.out.println("Admin is unable to navigate to first page"+e);
				Assert.fail();
		}
	}

		
		@Then("admin will count total number of items present on title bar of media table")
		public void admin_will_count_total_number_of_items_present_on_title_bar_of_media_table() {
			try {
				String totalitems= driver.findElement(By.xpath("//*[@id='posts-filter']/div[2]/div[2]/span[1]")).getText();
				System.out.println("Total number of images in the media table are:"+totalitems);
				System.out.println("----------------------------");
				}
			catch (Exception e) {
				System.out.println("Admin is not able to count total number of items on the title bar of media table"+e);
				Assert.fail();
			}
	}
	
	
		@Given("Admin will hover over media section and selects library option from dropdown")
		public void admin_will_hover_over_media_section_and_selects_library_option_from_dropdown() {
			try {
				WebElement Media= driver.findElement(By.xpath("//li[@id='menu-media']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(Media);
				Thread.sleep(1000);

	
				WebElement library= driver.findElement(By.xpath("//li[@id='menu-media']/a/div[3]"));
				actions.moveToElement(library);
				actions.click().build().perform();
				}
			catch (Exception e) {
				System.out.println("Admin is not able to hover over media section"+e);
				Assert.fail();
		}
	}

		@When("admin will click on edit image option")
		public void admin_will_click_on_edit_image_option() {
			try {
				WebElement element = driver.findElement(By.xpath("//*[@id='post-11773']/td[1]/div/span[1]/a"));
				JavascriptExecutor js = (JavascriptExecutor)driver;                                              //in order to click a non visible element
				js.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
	            } 
			
			catch (Exception e) {
				System.out.println("Admin is not able to click on title of image"+e);
				Assert.fail();
		}
	}

		@Then("admin navigate to edit media webpage")
		public void admin_navigate_to_edit_media_webpage() {
			try {
				String expectedtitle="Edit Media ‹ Real Estate — WordPress";
				String actualtitle=driver.getTitle();
				Assert.assertEquals(expectedtitle,actualtitle);
				Thread.sleep(1000);
				System.out.println("Actual Title is:" +actualtitle);
				System.out.println("----------------------------");
				}
			catch (Exception e) {
				System.out.println("Edit media webpage is unavailable"+e);
				Assert.fail();
		}
	   
	}
	
	
		@And("admin will enter {string} in caption field and {string} in alternative text field and {string} in the description field")
		public void admin_will_enter_in_caption_field_and_in_alternative_text_field_and_in_the_description_field(String caption, String alternativetext, String content) {
		  try {
			  driver.findElement(By.id("attachment_caption")).clear();
			  Thread.sleep(1000);
			  driver.findElement(By.id("attachment_caption")).sendKeys(caption);
			  Thread.sleep(1000);
			  System.out.println("Admin is able to enter caption"); 
			  System.out.println("----------------------------");
			  
			  driver.findElement(By.id("attachment_alt")).clear();
			  Thread.sleep(1000);
			  driver.findElement(By.id("attachment_alt")).sendKeys(alternativetext);
			  Thread.sleep(1000);
			  System.out.println("Admin is able to enter alttext");
			  System.out.println("----------------------------");
			  
			  driver.findElement(By.id("attachment_content")).clear();
			  Thread.sleep(1000);
			  driver.findElement(By.id("attachment_content")).sendKeys(content);
			  Thread.sleep(1000); 
			  System.out.println("Admin is able to enter content in the description field");
			  System.out.println("----------------------------");
			  
		  	} 
		  catch (Exception e) {
			  System.out.println("Admin is not able to enter the data in the above mentioned fields"+e);
			  Assert.fail();
		}
		  
	}
	

		@And("then admin enter the {string} in title bar present above the image and clicks on update tab")
		public void then_admin_enter_the_in_title_bar_present_above_the_image_and_clicks_on_update_tab(String Title) {
		  try {
			  driver.findElement(By.id("title")).clear();
			  Thread.sleep(1000);
			  driver.findElement(By.id("title")).sendKeys(Title);
			  Thread.sleep(1000);
			  driver.findElement(By.id("publish")).click();
			  Thread.sleep(1000);
			  System.out.println("admin is able to click on update tab");
			  System.out.println("----------------------------");
			  } 
		  
		  catch (Exception e) {
			  System.out.println("Admin is able to enter title in the title field"+e);
			  Assert.fail();
		} 
		  
	  }
	  
		@Then("admin verifies success message")
		public void admin_verifies_success_message() {
			try {
				Boolean Display = driver.findElement(By.xpath("//*[@id='message']/p")).isDisplayed();
				System.out.println("Admin verifies success message :"+Display);
				System.out.println("----------------------------");
				} 
			catch (Exception e) {
				System.out.println("Admin is not able to verify success message"+e);
				Assert.fail();
			}
	     
	  }

		
	@And("admin clicks on library section and verifies the title on media library webpage")
	  public void admin_clicks_on_library_section_and_verifies_the_title_on_media_library_webpage() {
		  
		  try {
			  	driver.findElement(By.xpath("//li[@id='menu-media']/a/div[3]")).click();
			  	Thread.sleep(1000);
			  	String expectedtitle=driver.findElement(By.xpath("//*[@id='post-11773']/td[1]/strong/a")).getText();
			  	String actualtitle="Tiger";
			  	Assert.assertEquals(expectedtitle, actualtitle);
			  	System.out.println("Title on the webpage is: "+actualtitle);
			  	System.out.println("----------------------------");
			  	
		  		} 
		  catch (Exception e) {
				System.out.println("Admin is not able to verify the title"+e);
				Assert.fail();
			}
		 }
	  
	  
	  @And("admin click on view option and verifies the content given in the description field")
	  public void admin_click_on_view_option_and_verifies_the_content_given_in_the_description_field() {
		  try {
				WebElement element = driver.findElement(By.xpath("//*[@id='post-11773']/td/div/span[3]/a"));
				JavascriptExecutor js = (JavascriptExecutor)driver;                                            //in order to click a non visible element
			    js.executeScript("arguments[0].click();", element);
			    Thread.sleep(1000);
			    
			    Boolean Display = driver.findElement(By.xpath("//*[@id='post-11773']/div/p[2]")).isDisplayed();
				System.out.println("Content is present: "+Display);
				System.out.println("----------------------------");
		  		}
		  
		  catch (Exception e) {
			  System.out.println("Admin is not able to click view option and hence unable to verify the content"+e);
			  Assert.fail();
			  }
		  }
}


