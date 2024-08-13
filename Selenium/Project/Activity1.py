from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")

    # Print the title of the page
    pagetitle= driver.title
    print("Page title is: ", pagetitle)
    assert pagetitle == "OrangeHRM"
driver.close()