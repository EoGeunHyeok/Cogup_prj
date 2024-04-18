package org.example.dao;

import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Check;
import org.example.dto.Cul;

public class CheckDao extends Dao{
    public DBConnection dbConnection;
    public CheckDao() {
        this.dbConnection = Container.getDBConnection();
    }

    public int addCheck (Check check) {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("INSERT INTO `Check`  "));
        sb.append(String.format("SET `time` = NOW() , ",check.time));
        sb.append(String.format("`reservation` = '%s' ,", check.reservation));
        sb.append(String.format("`name` = '%s' ", check.name));

        return dbConnection.insert(sb.toString());


    }
}
