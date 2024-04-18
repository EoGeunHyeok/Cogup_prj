package org.example.dao;

import lombok.Getter;
import lombok.Setter;
import org.example.container.Container;
import org.example.db.DBConnection;
import org.example.dto.Cul;
import org.example.dto.Member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
public class CulDao extends Dao {
    public DBConnection dbConnection;

    public CulDao() {
        this.dbConnection = Container.getDBConnection();
    }

    // 출석 정보 추가
    public int addAttendance(Cul cul) {

            StringBuilder sb = new StringBuilder();

            sb.append(String.format("INSERT INTO Cul  "));
            sb.append(String.format("SET member_name = '%s', ", cul.name));
            sb.append(String.format("regDate = NOW() , ",cul.checkTime));
            sb.append(String.format("updateDate = NOW(),", cul.checkTime));
            sb.append(String.format("`status` = '%s'  ",cul.checkStatus));

            return dbConnection.insert(sb.toString());


        }
    }
