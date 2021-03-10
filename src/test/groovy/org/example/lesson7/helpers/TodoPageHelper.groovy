package org.example.lesson7.helpers

import groovy.util.logging.Log4j
import org.example.lesson7.pages.TodoPage

@Log4j
class TodoPageHelper {

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
        boolean result = true
        log.info("Check if input field displayed - $result")
        result
    }

    String getInputFieldPlaceholder() {
        String result = 'What needs to be done?'
        log.info("Check input placeholder - $result")
        result
    }

    boolean isFooterDisplayed() {
        boolean result = false
        log.info("Check if footer displayed - $result")
        result
    }

    TodoPageHelper createTask(task) {
        log.info("Create a new task - $task")
        this
    }

    boolean isTaskDisplayed(task) {
        boolean result = true
        log.info("Check if task[$task] displayed - $result")
        result
    }

    String getItemsLeftCounterText() {
        def text = 'text'
        log.info("Check items left counter text - $text")
        text
    }

    TodoPageHelper selectAllFilter() {
        log.info("Select 'All' filter")
        this
    }

    TodoPageHelper updateTask(task, newTask) {
        log.info("Update task[$task] name - $newTask")
        this
    }

    TodoPageHelper deleteTask(task) {
        log.info("Delete task[$task]")
        this
    }

    TodoPageHelper completeTask(task) {
        log.info("Complete task[$task]")
        this
    }

    boolean isTaskCompleted(task) {
        boolean result = true
        log.info("Check if task[$task] completed - $result")
        result
    }

    boolean isClearCompletedButtonDisplayed() {
        boolean result = true
        log.info("Check if 'Clear Completed' button displayed - $result")
        result
    }

    TodoPageHelper uncompleteTask(task) {
        log.info("Uncomplete task[$task]")
        this
    }

    boolean isTaskUncompleted(task) {
        boolean result = true
        log.info("Check if task[$task] uncompleted - $result")
        result
    }

    TodoPageHelper selectActiveFilter() {
        log.info("Select 'Active' filter")
        this
    }

    TodoPageHelper selectCompletedFilter() {
        log.info("Select 'Completed' filter")
        this
    }

}
