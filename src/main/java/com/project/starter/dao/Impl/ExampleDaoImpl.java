package com.project.starter.dao.Impl;

import com.project.starter.dao.AbstractDao;
import com.project.starter.dao.ExampleDao;
import com.project.starter.dto.ExampleDto;
import com.project.starter.exception.RecordingErrorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExampleDaoImpl extends AbstractDao implements ExampleDao {

    @Value("${env.SPRING_DATASOURCE_URL}")
    public String dbUrl;

    @Value("${env.SPRING_DATASOURCE_USERNAME}")
    public String dbUsername;

    @Value("${env.SPRING_DATASOURCE_PASSWORD}")
    public String dbPass;

    @Override
    public List<ExampleDto> getExampleInfoQuery(int page, int size) throws Exception {
        List<ExampleDto> result = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            ArrayList param = new ArrayList();
            sql.append(" SELECT COUNT(*) OVER() AS TOTAL,ID, FIRSTNAME, LASTNAME, GENDER, ");
            sql.append(" AGE, ACTIVE, CREATE_DATE FROM ");
            sql.append(" (SELECT ID, FIRSTNAME, LASTNAME, GENDER, AGE, ACTIVE, CREATE_DATE ");
            sql.append(" FROM public.user_info ");
            sql.append(" LIMIT ? ");
            sql.append(" OFFSET ? ) AS US ");
            param.add(size);
            param.add(page*size);

            result = getJdbcTemplate().query(sql.toString(), new RowMapper<ExampleDto>() {
                @Override
                public ExampleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                    ExampleDto obj = new ExampleDto();
                    obj.setTotal(rs.getInt("TOTAL"));
                    obj.setUserId(rs.getInt("ID"));
                    obj.setFirstName(rs.getString("FIRSTNAME"));
                    obj.setLastName(rs.getString("LASTNAME"));
                    obj.setGender(rs.getString("GENDER"));
                    obj.setAge(rs.getInt("AGE"));
                    obj.setActive(rs.getBoolean("ACTIVE"));
                    obj.setCreateDate(rs.getString("CREATE_DATE"));
                    return obj;
                }
            },param.toArray());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Errors occurred in getExampleInfo");
        }
        return result;
    }

    @Override
    public Boolean createUser(ExampleDto request) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPass);
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append(" INSERT INTO public.user_info ");
            sql.append(" (FIRSTNAME, LASTNAME, GENDER, AGE, ACTIVE, CREATE_DATE) ");
            sql.append(" VALUES( ?, ?, ?, ?, ?, CURRENT_TIMESTAMP); ");
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, request.getFirstName());
            statement.setString(2, request.getLastName());
            statement.setString(3, request.getGender());
            statement.setInt(4, request.getAge());
            statement.setBoolean(5, request.getActive());
            statement.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    throw new RecordingErrorException("Data Insertion Fail.");
                }
            }
            throw new RecordingErrorException("Data Insertion Fail.");
        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Data Insertion Fail.");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public Boolean editUser(ExampleDto request) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPass);
            connection.setAutoCommit(false);

            StringBuilder sql = new StringBuilder();
            sql.append(" UPDATE public.user_info ");
            sql.append(" SET FIRSTNAME= ?, LASTNAME= ?, GENDER= ?, AGE= ?, ACTIVE= ?, CREATE_DATE=CURRENT_TIMESTAMP ");
            sql.append(" WHERE ID = ? ");
            statement = connection.prepareStatement(sql.toString());
            statement.setString(1, request.getFirstName());
            statement.setString(2, request.getLastName());
            statement.setString(3, request.getGender());
            statement.setInt(4, request.getAge());
            statement.setBoolean(5, request.getActive());
            statement.setInt(6, request.getUserId());
            statement.execute();

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    throw new RecordingErrorException("Data Update Fail.");
                }
            }
            throw new RecordingErrorException("Data Update Fail.");
        } catch (Exception ex){
            ex.printStackTrace();
            throw new Exception("Data Update Fail.");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
