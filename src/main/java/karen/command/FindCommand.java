package karen.command;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import karen.Storage;
import karen.Ui;
import karen.task.Task;

/**
 * To search Task's descriptions to match with a given keyword.
 */
public class FindCommand extends Command {
    protected String keyTerm;

    public FindCommand(String inputTerm) {
        keyTerm = inputTerm;
    }

    /**
     * Finds Task with matching description with keyTerm.
     *
     * @param ui To control outputs related to execution
     * @param storage To access and modify Tasks stored in Storage
     * @return String result of output from successful execution of Command
     */
    @Override
    public String execute(Ui ui, Storage storage) {
        Pattern keyTermFormat = Pattern.compile(keyTerm);
        ArrayList<Task> matchingList = new ArrayList<>();

        for (Task item: storage.getTaskList()) {
            Matcher checkMatch = keyTermFormat.matcher(item.getDescription());
            if (checkMatch.matches()) {
                matchingList.add(item);
            }
        }

        StringBuilder formatString = new StringBuilder();

        // if matching results found
        if (matchingList.size() > 0) {
            formatString.append("You made me find to just get this:\n");
        }

        formatString.append(ui.formatTaskList(matchingList));
        return ui.displayUserInput(formatString.toString());
    }
}
