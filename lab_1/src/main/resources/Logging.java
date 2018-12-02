import java.util.logging.Logger;

public class Logging {
    private static Logger log = Logger.getLogger(Logging.class.getName());

    public void someMethod()
    {
        log.info("Some message");
    }
}
