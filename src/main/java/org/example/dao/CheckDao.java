package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Check;
import org.example.dto.Cul;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckDao extends Dao {
    public DBConnection dbConnection;

    public CheckDao() {
        this.dbConnection = Container.getDBConnection();
    }

    public int addCheck(Check check) {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO `Check`  "));
        sb.append(String.format("SET `time` = NOW() , ", check.time));
        sb.append(String.format("`reservation` = '%s' ,", check.reservation));
        sb.append(String.format(" checkPw = '%s' ,", check.checkPw));
        sb.append(String.format("`name` = '%s' ", check.name));

        return dbConnection.insert(sb.toString());


    }

    public int cancelCheck(int timeSlot){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("DELETE FROM `Check` "));
        sb.append(String.format("WHERE `reservation` = %d ", timeSlot));

        return dbConnection.delete(sb.toString());

    }




}
