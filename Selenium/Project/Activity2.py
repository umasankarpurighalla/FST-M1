import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webelement import WebElement
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login")
url = driver.current_url
# Printing the URL
print("current url: ", url)
time.sleep(5)
get_urlheaderimage = driver.find_element(By. XPATH,"// img[contains(@src,'logo')]")
print("HRM Home page url header image: ", get_urlheaderimage)
driver.close()