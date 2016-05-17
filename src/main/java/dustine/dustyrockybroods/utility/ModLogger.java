package dustine.dustyrockybroods.utility;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.FormattedMessage;

public class ModLogger {
    private static Logger LOGGER;

    public static void init(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();
    }

    public static void trace(String str, Object... params) {
        LOGGER.log(Level.TRACE, new FormattedMessage(str, params));
    }

    public static void debug(String str, Object... params) {
        LOGGER.log(Level.DEBUG, new FormattedMessage(str, params));
    }

    public static void info(String str, Object... params) {
        LOGGER.log(Level.INFO, new FormattedMessage(str, params));
    }

    public static void warn(String str, Object... params) {
        LOGGER.log(Level.WARN, new FormattedMessage(str, params));
    }

    public static void error(String str, Object... params) {
        LOGGER.log(Level.ERROR, new FormattedMessage(str, params));
    }

    public static void error(String str, Throwable exception, Object... params) {
        LOGGER.log(Level.ERROR, new FormattedMessage(str, params, exception));
    }

    public static void fatal(String str, Throwable exception, Object... params) {
        LOGGER.log(Level.FATAL, new FormattedMessage(str, params, exception));
    }
}
