package co.bk.task.threading.config;

public class TaskServiceException extends RuntimeException {

    private static final long serialVersionUID = -6830217399064846339L;

    public TaskServiceException(String message) {
        super(message);
    }

    public TaskServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskServiceException(Throwable cause) {
        super(cause);
    }

}
