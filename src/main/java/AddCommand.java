public class AddCommand extends Command {
    protected Task item;

    public AddCommand(Task item) {
        this.item = item;
    }

    @Override
    public void execute(Ui ui, Storage storage) {
        storage.addTask(item);
        ui.displayUserInput(ui.formatCount("added", item, storage.getTaskCount()));

    }
}
