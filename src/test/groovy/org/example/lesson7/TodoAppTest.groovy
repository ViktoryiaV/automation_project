package org.example.lesson7

import groovy.util.logging.Log4j
import org.example.lesson7.helpers.TodoPageHelper
import org.example.lesson7.projectutils.TodoAppCleaner
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

import java.lang.reflect.Method

import static org.testng.Assert.*

@Log4j
class TodoAppTest extends BaseTest {

    TodoPageHelper todoPageHelper = new TodoPageHelper()

    @BeforeMethod
    void navigate(Method m) {
        if (m.getName() == 'navigateTest') {
            return
        }
        TodoAppCleaner.clean()
        todoPageHelper.navigate()
    }

    @Test(priority = 101)
    void navigateTest() {

        todoPageHelper.navigate()
        assertTrue(todoPageHelper.isTodoHeaderDisplayed(),'Todo page header is not displayed')
        assertTrue(todoPageHelper.isInputFieldDisplayed(),'Input field is not displayed')
        assertEquals(todoPageHelper.getInputFieldPlaceholder(), 'What needs to be done?','Wrong placeholder text for input field')
        assertFalse(todoPageHelper.isFooterDisplayed(),'Todo page footer is displayed')

    }

    @Test(priority = 102)
    void createTaskTest() {
        def task = 'My test task'
        todoPageHelper.createTask(task)

        assertTrue(todoPageHelper.isTaskDisplayed(task), 'User not able to create a new task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter value')
    }

    @Test(priority = 103)
    void editTaskTest() {
        def task = 'My test task'
        def newTaskName = 'My test new task'
        todoPageHelper.createTask(task).selectAllFilter().updateTask(task, newTaskName)

        assertTrue(todoPageHelper.isTaskDisplayed(newTaskName), 'User not able to edit existing task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after edit')
    }

    @Test(priority = 104)
    void deleteTaskTest() {
        def task1 = 'My task 1'
        def task2 = 'My task 2'
        todoPageHelper.createTask(task1).createTask(task2)
                .selectAllFilter().deleteTask(task1)

        assertFalse(todoPageHelper.isTaskDisplayed(task1), 'User not able to delete task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after delete')
    }

    @Test(priority = 105)
    void deleteThaLastTaskTest() {
        def task = 'My task'
        todoPageHelper.createTask(task).deleteTask(task)

        assertFalse(todoPageHelper.isTaskDisplayed(task), 'User not able to delete task')
        assertFalse(todoPageHelper.isFooterDisplayed(),'Todo page footer is displayed')
    }

    @Test(priority = 106)
    void completeTaskTest() {
        def task = 'My task'
        todoPageHelper.createTask(task).selectAllFilter().completeTask(task)

        assertTrue(todoPageHelper.isTaskCompleted(task), 'User is not able to complete task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '0 items left', 'Wrong items counter after delete')
        assertTrue(todoPageHelper.isClearCompletedButtonDisplayed(),
                "'Clear completed' button is not displayed after user completes some task")
    }

/*
    @Test(priority = 107)
    void uncompleteTaskTest() {
        def task = 'My task'
        todoPageHelper.createTask(task).selectAllFilter().completeTask(task)
                .uncompleteTask(task)

        assertTrue(todoPageHelper.isTaskUncompleted(task), 'User is not able to uncomplete task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after delete')
    }

    @Test(priority = 108)
    void allFilterTest() {
        def task1 = 'My task 1'
        def task2 = 'My task 2'
        todoPageHelper.createTask(task1).createTask(task2)
                .selectAllFilter().completeTask(task1)

        assertTrue(todoPageHelper.isTaskDisplayed(task1), 'Completed task is not displayed')
        assertTrue(todoPageHelper.isTaskCompleted(task1), 'Displayed task is not completed')
        assertTrue(todoPageHelper.isTaskDisplayed(task2), 'Uncompleted task is not displayed')
        assertTrue(todoPageHelper.isTaskUncompleted(task2), 'Displayed task is completed')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after delete')
    }

    @Test(priority = 109)
    void activeFilterTest() {
        def task1 = 'My task 1'
        def task2 = 'My task 2'
        todoPageHelper.createTask(task1).createTask(task2)
                .selectAllFilter().completeTask(task1).selectActiveFilter()

        assertFalse(todoPageHelper.isTaskDisplayed(task1), 'Completed task is displayed')
        assertTrue(todoPageHelper.isTaskDisplayed(task2), 'Uncompleted task is not displayed')
        assertTrue(todoPageHelper.isTaskUncompleted(task2), 'Displayed task is completed')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after delete')
    }

    @Test(priority = 110)
    void completedFilterTest() {
        def task1 = 'My task 1'
        def task2 = 'My task 2'
        todoPageHelper.createTask(task1).createTask(task2)
                .selectAllFilter().completeTask(task1).selectCompletedFilter()

        assertTrue(todoPageHelper.isTaskDisplayed(task1), 'Completed task is not displayed')
        assertTrue(todoPageHelper.isTaskCompleted(task1), 'Displayed task is not completed')
        assertFalse(todoPageHelper.isTaskDisplayed(task2), 'Uncompleted task is displayed')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after delete')
    }
*/
}
