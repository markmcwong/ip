package duke.task;

import java.util.ArrayList;
import java.util.List;

/**
 * The list that contains and holds all the tasks imported/added by the user
 * handles operation to the list including add, update and delete
 */
public class TaskList {
    private List<ListItem> listItems;

    public TaskList() {
        this.listItems = new ArrayList<>();
    }

    public TaskList(List<ListItem> inputList) {
        this.listItems = new ArrayList<ListItem>(inputList);
    }

    /**
     * Immutable way to add the new task by returning a new list
     *
     * @param task the task to be added to the list
     */
    public TaskList addCommand(ListItem task) {
        List<ListItem> tempList = new ArrayList<>(this.listItems);
        tempList.add(task);
        return new TaskList(tempList);
    }

    /**
     * Mutable way to add the new task by modifying the list
     *
     * @param task the task to be added to the list
     */
    public void addCommandMutable(ListItem task) {
        this.listItems.add(task);
    }

    public List<ListItem> getListItems() {
        return this.listItems;
    }

    /**
     * Mutable way to mark the task as done by directly changing item in the list
     *
     * @param index the index of the item to be changed
     */
    public void updateItemMutable(int index) {
        int correctIndex = index - 1;
        assertIndexInRange(correctIndex);
        ListItem tempItem = this.listItems.get(correctIndex).markAsDone();
        assert tempItem.getDone(); // check the updated item's done status is true
        this.listItems.set(correctIndex, tempItem);
    }

    /**
     * Mutable way to delete the task by directly removing item in the list
     *
     * @param index the index of the item to be changed
     */
    public void deleteCommandMutable(int index) {
        int correctIndex = index - 1;
        assertIndexInRange(correctIndex);
        this.listItems.remove(correctIndex);
    }

    /**
     * Look for all items that contains the <code>keyword</code> and return the list
     *
     * @param keyword the keyword to be searched through the TaskList, in SQL LIKE syntax
     */
    public TaskList findItem(String keyword) {
        List<ListItem> tempList = new ArrayList<>();
        for (ListItem item : listItems) {
            if (item.getTask().contains(keyword)) {
                tempList.add(item);
            }
        }
        return new TaskList(tempList);
    }

    @Override
    public String toString() {
        String initStr = "";
        for (int i = 0; i < this.listItems.size(); i++) {
            ListItem tempItem = this.listItems.get(i);
            initStr = initStr + (tempItem.getClass().getName().charAt(0)
                    + "|" + tempItem.getDone() + "|" + tempItem.getTask() + tempItem.getDate() + "\n");
        }
        return initStr;
    }

    // a method with an assertion that checks the index is >= 0 so it can be used for indexing with the List
    public void assertIndexInRange(int index){
        assert index >= 0;
    }
}
