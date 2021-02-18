package duke.system.exception;

public abstract class DukeException extends Exception {

    private static final long serialVersionUID = 1L;

    public DukeException(String errorMessage) {
        super(errorMessage);
    }

    public static class NoDescriptionException extends DukeException {
        public NoDescriptionException(String itemClass) {
            super("OOPS!!! The argument of the command " + itemClass + " cannot be empty or is in wrong format.");
        }
    }

    public static class UnknownCommandException extends DukeException {
        public UnknownCommandException() {
            super("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    public static class InputOutputErrorException extends DukeException {
        public InputOutputErrorException() {
            super("IO Error!");
        }
    }
}
