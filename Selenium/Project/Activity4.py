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
pagetitle = driver.title
print("page title is: ", pagetitle)
pim_menu = driver.find_element(By.ID, "menu_pim_viewPimModule")
pim_menu.click()
employeelist = driver.find_element(By.ID, "menu_pim_viewEmployeeList")
employeelist.click()
addemployee = driver.find_element(By.ID, "btnAdd")
addemployee.click()
firstname = driver.find_element(By.ID, "firstName")
firstname.send_keys("abc")
lastname = driver.find_element(By.ID, "lastName")
lastname.send_keys("def1")
get_employeeid = driver.find_element(By.ID, "employeeId").get_dom_attribute("value")
driver.find_element(By.ID, "btnSave").click()
driver.find_element(By.ID, "menu_pim_viewPimModule").click()
driver.find_element(By.ID, "empsearch_id").send_keys(get_employeeid)
driver.find_element(By.ID, "searchBtn").click()
tableResult = driver.find_elements(By.XPATH, "//table[@id = 'resultTable']/tbody/tr/td")
assert (len(tableResult), "No records", get_employeeid) == (len(tableResult), "No records", get_employeeid)
driver.close()