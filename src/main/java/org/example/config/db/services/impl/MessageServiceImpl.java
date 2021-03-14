package org.example.config.db.services.impl;

import org.example.config.db.DbWorker;
import org.example.config.db.services.MessageService;
import org.example.domain.Message;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Override
    public List<Message> getAll() throws SQLException {
        ResultSet resultSet = DbWorker.getInstance().executeSelectQuery("select * from message;");
        List<Message> messages = new ArrayList<>();
        while(resultSet.next()) {
            messages.add(new Message(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }
        resultSet.close();
        return messages;
    }

    @Override
    public void insert(Message message) throws SQLException {
        DbWorker.getInstance().executeQuery("insert into message values (?, ?, ?);", message.getId(), message.getTag(), message.getText());
    }
}
