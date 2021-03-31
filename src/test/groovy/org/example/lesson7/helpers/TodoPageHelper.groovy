package org.example.lesson7.helpers

import groovy.util.logging.Log4j
import org.example.lesson7.pages.BasePage
import org.example.lesson7.pages.TodoPage

@Log4j
class TodoPageHelper extends BaseHelper {

    TodoPage page = new TodoPage()

    TodoPageHelper navigate() {
        log.info('Navigate Todo app')
        page.navigate()
        this
    }

    boolean isTodoHeaderDisplayed() {
        boolean result = page.isTodoHeaderDisplayed()
        log.info("Check if todo header displayed - $result")
        result
    }

    boolean isInputFieldDisplayed() {
        boolean result = page.isInputFieldDisplayed()
        log.info("Check if input field displayed - $result")
        result
    }

    String getInputFieldPlaceholder() {
        String result = page.getInputFieldPlaceholder()
        log.info("Check input placeholder - $result")
        result
    }

    boolean isFooterDisplayed() {
        boolean result = page.isFooterDisplayed()
        log.info("Check if footer displayed - $result")
        result
    }

    TodoPageHelper createTask(task) {
        log.info("Create a new task - $task")
        page.createTask(task)
        this
    }

    boolean isTaskDisplayed(task) {
        boolean result = page.isTaskDisplayed(task)
        log.info("Check if task[$task] displayed - $result")
        result
    }

    String getItemsLeftCounterText() {
        def text = page.getItemsLeftCounterText()
        log.info("Check items left counter text - $text")
        text
    }

    TodoPageHelper selectAllFilter() {
        log.info("Select 'All' filter")
        page.clickAllFilter()
        this
    }

    TodoPageHelper updateTask(task, newTask) {
        log.info("Update task[$task] name - $newTask")
        page.updateTask(task, newTask)
        this
    }

    TodoPageHelper deleteTask(task) {
        log.info("Delete task[$task]")
        page.clickDeleteIconForTask(task)
        this
    }

    TodoPageHelper completeTask(task) {
        log.info("Complete task[$task]")
        if (!page.isTaskCompleted(task)) {
            page.clickTaskCheckbox(task)
        }
        this
    }

    boolean isTaskCompleted(task) {
        boolean result = page.isTaskCompleted(task)
        log.info("Check if task[$task] completed - $result")
        result
    }

    boolean isClearCompletedButtonDisplayed() {
        boolean result = page.isClearCompletedButtonDisplayed()
        log.info("Check if 'Clear Completed' button displayed - $result")
        result
    }

    TodoPageHelper uncompleteTask(task) {
        log.info("Uncomplete task[$task]")
        if(page.isTaskCompleted(task)) {
            page.clickTaskCheckbox(task)
        }
        this
    }

    TodoPageHelper selectActiveFilter() {
        log.info("Select 'Active' filter")
        page.clickActiveFilter()
        this
    }

    TodoPageHelper selectCompletedFilter() {
        log.info("Select 'Completed' filter")
        page.clickCompletedFilter()
        this
    }

}
