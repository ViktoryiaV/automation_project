package project.pages

import my.testframework.pages.BasePage
import my.testframework.utils.uielements.WebElement
import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions

class TodoPage extends BasePage {

    private WebElement todoHeader = new WebElement('//header/h1')
    private WebElement inputField = new WebElement("//input[contains(@class, 'new-todo')]")
    private WebElement footer = new WebElement("//footer[contains(@class, 'footer')]")
    private WebElement itemsLeftCounter = new WebElement("//footer//span[contains(@class, 'todo-count')]")
    private WebElement allFilter = new WebElement("//footer//ul[contains(@class, 'filters')]//a[text()='All']")
    private WebElement activeFilter = new WebElement("//footer//ul[contains(@class, 'filters')]//a[text()='Active']")
    private WebElement completedFilter = new WebElement("//footer//ul[contains(@class, 'filters')]//a[text()='Completed']")
    private WebElement clearCompletedButton = new WebElement("//button[text()='Clear completed']")

    private WebElement getTask(name) {
        new WebElement("//ul[contains(@class, 'todo-list')]//label[text()='$name']")
    }

    private WebElement getTaskCheckbox(name) {
        new WebElement("${getTask(name)}/..//input[@class='toggle']")
    }

    private WebElement getTaskCheckedCheckbox(name) {
        new WebElement("${getTaskCheckbox(name)}[@checked]")
    }

    private WebElement getTaskDeleteIcon(name) {
        new WebElement("//ul[contains(@class, 'todo-list')]//label[text()='$name']/..//button")
    }

    TodoPage getPage() {
        inputField.waitForVisible()
        this
    }

    TodoPage navigate() {
        driver.get(BASE_URL)
        getPage()
    }

    boolean isTodoHeaderDisplayed() {
        todoHeader.isDisplayed()
    }

    boolean isInputFieldDisplayed() {
        inputField.isDisplayed()
    }

    String getInputFieldPlaceholder() {
        inputField.getAttribute('placeholder')
    }

    boolean isFooterDisplayed() {
        footer.isDisplayed()
    }

    TodoPage createTask(task) {
        inputField.with {
            clear()
            sendKeys(task + Keys.ENTER)
        }
    }

    boolean isTaskDisplayed(task) {
        getTask(task).isDisplayed()
    }

    String getItemsLeftCounterText() {
        itemsLeftCounter.getText()
    }

    TodoPage clickAllFilter() {
        allFilter.click()
        getPage()
    }

    TodoPage updateTask(task, newTask) {
        def backSpaces = (1..task.toString().length()).collect { Keys.BACK_SPACE }.join('')
        new Actions(driver)
                .doubleClick(getTask(task).getElement()).sendKeys(backSpaces).sendKeys(newTask + Keys.ENTER)
                .build().perform()
        getPage()
    }

    TodoPage clickDeleteIconForTask(task) {
        def label = getTask(task).getElement()
        def iconX = getTaskDeleteIcon(task).getElement()
        new Actions(driver).moveToElement(label).click(iconX).build().perform()
        getPage()
    }

    boolean isTaskCompleted(task) {
        if (getTaskCheckedCheckbox(task).isPresent()) {
            return getTaskCheckedCheckbox(task).getSize().width > 0
        }
        false
    }

    TodoPage clickTaskCkeckbox(task) {
        getTaskCheckbox(task).click()
        getPage()
    }

    boolean isClearCompletedButtonDisplayed() {
        clearCompletedButton.isDisplayed()
    }

}
