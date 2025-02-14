package command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import karen.KarenException;
import karen.command.InvalidCommand;
import karen.command.InvalidMessage;

public class InvalidCommandTest {
    @Test
    public void constructorOverload() {
        assertEquals("I don't understand anything - I want to speak with your manager",
                new InvalidCommand().getMessage());
        assertEquals("Wrong date formatting. It should be in yyyy-mm-dd HHmm.",
                new InvalidCommand(InvalidMessage.INVALID_DATE).getMessage());
    }

    @Test
    public void executeCommand() {
        try {
            InvalidCommand cmd = new InvalidCommand();
            // temp stub for execution of InvalidCommand
            throw new KarenException(cmd.getMessage());
        } catch (KarenException err) {
            assertEquals("I don't understand anything - I want to speak with your manager",
                    err.getMessage());
        }
    }

}
