from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
import time

# Set up the Firefox Driver with WebDriverManager
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the OrangeHRM page
    driver.get("http://alchemy.hguy.co/orangehrm")

    # Login with credentials
    username = driver.find_element(By.ID, "txtUsername")
    username.send_keys("orange")

    password = driver.find_element(By.ID, "txtPassword")
    password.send_keys("orangepassword123")

    login_btn = driver.find_element(By.ID, "btnLogin")
    login_btn.click()

driver.find_element(By.ID, "menu_pim_viewMyDetails").click()
driver.find_element(By.XPATH, "//a[text()='Emergency Contacts']").click()
driver.find_element(By.ID, "btnAddContact").click()
driver.find_element(By.ID, "emgcontacts_name").send_keys("abc")
driver.find_element(By.ID, "emgcontacts_relationship").send_keys("friend")
driver.find_element(By.ID, "btnSaveEContact").click()
alldetails = driver.find_elements(By.XPATH, "//*[@id='frmEmpDelEmgContacts']")
print("All records: ", alldetails)
driver.close()