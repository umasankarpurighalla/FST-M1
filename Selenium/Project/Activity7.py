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

    # Find the "My Info" menu item and click it
    my_info_menu = driver.find_element(By.ID, "menu_pim_viewMyDetails")
    my_info_menu.click()

    # Find the Qualification option on the left side menu and click it
    qualifications_option = driver.find_element(By.XPATH, "//a[text()='Qualifications' and not(@class='arrow')]")
    qualifications_option.click()

    # Add Work Experience and click Save
    add_work_experience_btn = driver.find_element(By.ID, "addWorkExperience")
    add_work_experience_btn.click()

    # Fill in Work Experience details
    company_name = driver.find_element(By.ID, "experience_employer")
    company_name.send_keys("ABC Company")

    job_title = driver.find_element(By.ID, "experience_jobtitle")
    job_title.send_keys("Software Engineer")

    from_date = driver.find_element(By.ID, "experience_from_date")
    from_date.send_keys("2024-01-01")

    to_date = driver.find_element(By.ID, "experience_to_date")
    to_date.send_keys("2024-12-31")

    # Save the work experience
    save_btn = driver.find_element(By.ID, "btnWorkExpSave")
    save_btn.click()

    # Wait for a while to see the result
    time.sleep(5)

    driver.close()
