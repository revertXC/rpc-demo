package serverCentre;

import java.io.IOException;

/**
 * 服务中心
 */
public interface ServerCentreAble {

    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();


}
