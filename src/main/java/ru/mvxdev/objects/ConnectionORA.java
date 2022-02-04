package ru.mvxdev.objects;


import oracle.jdbc.pool.OracleDataSource;
import oracle.jms.AQjmsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.sql.SQLException;

@Component
public class ConnectionORA {
    private static Logger logger = LoggerFactory.getLogger(ConnectionORA.class);
    //-----------db-properties--------
    private OracleDataSource ods;
    private String url;
    private String login;
    private String pass;
    //--------queue-properties--------------
    private QueueConnectionFactory queueConnectionFactory;
    private QueueConnection connection;
    private QueueSession session;
    private QueueSender sender;
    private Queue queue;

    //-------------getters-----------------------
    public String getUrl(){
        return url;
    }

    public String getLogin(){
        return login;
    }

    public String getPass(){
        return pass;
    }

    public OracleDataSource getOds() {
        return ods;
    }
//----------------setters----------------------------------
    public void setOds(OracleDataSource ods) {
        this.ods = ods;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public ConnectionORA(){};

    public void initialize() throws SQLException, JMSException {
        ods = new OracleDataSource();
        ods.setURL(url);
        ods.setUser(login);
        ods.setPassword(pass);

        queueConnectionFactory = AQjmsFactory.getQueueConnectionFactory(ods);
        connection = queueConnectionFactory.createQueueConnection();
        connection.start();

        session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        sender = session.createSender(null);

        logger.info("Connect to DB");
    }

    public void sendTextMsg(String queueName,String data) throws JMSException {
        queue = session.createQueue("jms_text_que");
        TextMessage message = session.createTextMessage(data);
        sender.send(queue, message);
        logger.info("text message sent");
    }

    @Override
    public String toString() {
        return "ConnectionORA{" +
                "url='" + url + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
