import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
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
time.sleep(15)
driver.find_element(By.XPATH, "//input[@value='Edit']").click()
firstname = driver.find_element(By.XPATH, "//input[@title='First Name']")
firstname.clear()
firstname.send_keys("yuvraj")
driver.find_element(By.ID, "btnSave").click()
driver.close()