package project.tests

import groovy.util.logging.Log4j
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import project.helpers.TodoPageHelper
import project.utils.TodoAppCleaner

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
        assertTrue(todoPageHelper.isTodoHeaderDisplayed(), 'Todo page header is not displayed')
        assertTrue(todoPageHelper.isInputFieldDisplayed(), 'Input field is not displayed')
        assertEquals(todoPageHelper.getInputFieldPlaceholder(), 'What needs to be done?',
                'Wrong placeholder text for input field')
        assertFalse(todoPageHelper.isFooterDisplayed(), 'Footer is displayed')
    }

    @Test(priority = 102)
    void createTaskTest() {
        def task = 'MY test task'
        todoPageHelper.createTask(task)

        assertTrue(todoPageHelper.isTaskDisplayed(task), 'User not able to create a new task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter value')
    }

    @Test(priority = 103)
    void editTaskTest() {
        def task = 'MY test task'
        def newTaskName = 'MY test new task'
        todoPageHelper.createTask(task).selectAllFilter().updateTask(task, newTaskName)

        assertTrue(todoPageHelper.isTaskDisplayed(newTaskName), 'User not able to edit existing task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after edit')
    }

    @Test(priority = 104)
    void deleteTaskTest() {
        def task1 = 'MY task 1'
        def task2 = 'MY task 2'
        todoPageHelper.createTask(task1).createTask(task2)
                .selectAllFilter().deleteTask(task1)

        assertFalse(todoPageHelper.isTaskDisplayed(task1), 'User not able to delete task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '1 item left', 'Wrong items counter after delete')
    }

    @Test(priority = 105)
    void deleteTheLastTaskTest() {
        def task = 'MY task'
        todoPageHelper.createTask(task).deleteTask(task)

        assertFalse(todoPageHelper.isTaskDisplayed(task), 'User not able to delete task')
        assertFalse(todoPageHelper.isFooterDisplayed(), 'Footer is displayed')
    }

    @Test(priority = 106)
    void completeTaskTest() {
        def task = 'MY task'
        todoPageHelper.createTask(task).selectAllFilter()
                .completeTask(task)
        assertTrue(todoPageHelper.isTaskCompleted(task), 'User is not able to complete task')
        assertEquals(todoPageHelper.getItemsLeftCounterText(), '0 items left', 'Wrong items counter after complete item')
        assertTrue(todoPageHelper.isClearCompletedButtonDisplayed(),
                "'Clear completed' button is not displayed after user complete some task")
    }

/*    @Test(priority = 107)
    void uncompleteTaskTest() {

    }

    @Test(priority = 108)
    void allFilterTest() {

    }

    @Test(priority = 109)
    void activeFilterTest() {

    }

    @Test(priority = 110)
    void completedFilterTest() {

    }*/

}
