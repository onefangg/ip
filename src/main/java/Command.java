public abstract class Command {
    public Command() {
    }

    public boolean isExit() {
        return false;
    }
    public abstract void execute(Ui ui, Storage storage) throws KarenException;
}
