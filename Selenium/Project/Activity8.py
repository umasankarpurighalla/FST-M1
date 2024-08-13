from hashlib import new

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.remote.webelement import WebElement
from selenium.webdriver.support.ui import Select
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
    dropdown = driver.find_element(By.ID, "applyleave_txtLeaveType")
    leaveType=Select(dropdown)
    dropdown.click()
    leaveType.select_by_value("1")

    fromleave = driver.find_element(By.ID, "applyleave_txtFromDate")
    fromleave.clear()
    fromleave.send_keys("2024-06-26")
    toleave = driver.find_element(By.ID, "applyleave_txtToDate")
    toleave.clear()
    toleave.send_keys("2024-06-26")
    driver.find_element(By.ID, "applyleave_txtComment").click()
    driver.find_element(By.ID, "applyBtn").click()

    driver.find_element(By.ID, "menu_leave_viewMyLeaveList").click()
    fromcal = driver.find_element(By.ID, "calFromDate")
    to = driver.find_element(By.ID, "calToDate")
    fromcal.clear()
    to.clear()
    fromcal.send_keys("2024-06-26")
    to.send_keys("2024-06-26")

    driver.find_element(By.ID, "btnSearch").click()
    status = driver.find_element(By.XPATH, "//table[@id = 'resultTable']/tbody/tr/td[6]").text
    assert status == "Pending Approval(1.00)"

driver.close()