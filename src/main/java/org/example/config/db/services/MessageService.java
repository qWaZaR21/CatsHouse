package org.example.config.db.services;

import org.example.domain.Message;

import java.sql.SQLException;
import java.util.List;

public interface MessageService {
    List<Message> getAll() throws SQLException;
    void insert(Message message) throws SQLException;
}
