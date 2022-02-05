package ru.mvxdev.objects;


import oracle.jdbc.pool.OracleDataSource;
import oracle.jms.AQjmsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        ods.setURL("jdbc:oracle:thin:@"+url);
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
        queue = session.createQueue(queueName);
        TextMessage message = session.createTextMessage(data);
        sender.send(queue, message);
        logger.info(String.format("sent msg into %s",queue));
    }

    public void disconnect() throws JMSException, SQLException {
        session.close();
        connection.stop();
        ods.close();
    }

    @Override
    public String toString() {
        return "ConnectionORA{" +
                "url='" + url + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }


    public ArrayList<QueuesList> queuesList() throws SQLException {
        Connection conn = ods.getConnection();
        String query = "select * from DBA_QUEUES";
        ArrayList<QueuesList> q_list = new ArrayList<>();

        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                q_list.add(new QueuesList(rs.getString("NAME"),rs.getString("OWNER"),
                        rs.getString("QUEUE_TYPE"),rs.getString("QUEUE_TABLE")));
            }
        }

        return q_list;
    }
}
