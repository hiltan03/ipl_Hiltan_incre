package com.wecp.progressive.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Cricketer;

public class CricketerDAOImpl implements CricketerDAO
{

    @Override
    public int addCricketer(Cricketer cricketer) throws SQLException
    {
        String query = "insert into cricketer (team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets) values (?,?,?,?,?,?,?,?)";
        try
        {
            PreparedStatement ps = DatabaseConnectionManager.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cricketer.getTeamId());
            ps.setString(2, cricketer.getCricketerName());
            ps.setInt(3, cricketer.getAge());
            ps.setString(4, cricketer.getNationality());
            ps.setInt(5, cricketer.getExperience());
            ps.setString(6, cricketer.getRole());
            ps.setInt(7, cricketer.getTotalRuns());
            ps.setInt(8, cricketer.getTotalWickets());

            int n = ps.executeUpdate();

            if(n > 0)
            {
                ResultSet rs = ps.getGeneratedKeys();
                while(rs.next())
                {
                    cricketer.setCricketerId(rs.getInt(1));
                    return (rs.getInt(1));
                }
            }
            
        }
        catch(SQLException sqlEx)
        {
           // sqlEx.printStackTrace();
           throw new SQLException(sqlEx.getMessage());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return (-1);
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException
    {
        String query = "delete from cricketer where cricketer_id = ?";
        try
        {
            PreparedStatement ps = DatabaseConnectionManager.getConnection().prepareStatement(query);
            ps.setInt(1, cricketerId);

            int n = ps.executeUpdate();
        }
        catch(SQLException sqlEx)
        {
            //sqlEx.printStackTrace();
            throw new SQLException(sqlEx.getMessage());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException
    {
        String query = "select * from cricketer";
        List<Cricketer> cricketers = new ArrayList<Cricketer>();

        try
        {
            PreparedStatement ps = DatabaseConnectionManager.getConnection().prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Cricketer obj = new Cricketer();
                obj.setCricketerId(rs.getInt(1));
                obj.setTeamId(rs.getInt(2));
                obj.setCricketerName(rs.getString(3));
                obj.setAge(rs.getInt(4));
                obj.setNationality(rs.getString(5));
                obj.setExperience(rs.getInt(6));
                obj.setRole(rs.getString(7));
                obj.setTotalRuns(rs.getInt(8));
                obj.setTotalWickets(rs.getInt(9));
                cricketers.add(obj);
            }

        }
        catch(SQLException sqlEx)
        {
            //sqlEx.printStackTrace();
            throw new SQLException(sqlEx.getMessage());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return (cricketers);
        
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException
    {
        String query = "select * from cricketer where cricketer_id = ?";

        try
        {
            PreparedStatement ps = DatabaseConnectionManager.getConnection().prepareStatement(query);
            ps.setInt(1, cricketerId);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                Cricketer obj = new Cricketer();
                obj.setCricketerId(rs.getInt(1));
                obj.setTeamId(rs.getInt(2));
                obj.setCricketerName(rs.getString(3));
                obj.setAge(rs.getInt(4));
                obj.setNationality(rs.getString(5));
                obj.setExperience(rs.getInt(6));
                obj.setRole(rs.getString(7));
                obj.setTotalRuns(rs.getInt(8));
                obj.setTotalWickets(rs.getInt(9));
                return (obj);
            }
        }
        catch(SQLException sqlEx)
        {
            //sqlEx.printStackTrace();
            throw new SQLException(sqlEx.getMessage());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return (null);
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException
    {
        String query = "update cricketer set team_id = ?, cricketer_name = ?, age = ?, nationality = ?, experience = ?, role = ?, total_runs = ?, total_wickets = ? where cricketer_id = ?";
        try
        {
            PreparedStatement ps = DatabaseConnectionManager.getConnection().prepareStatement(query);
            ps.setInt(1, cricketer.getTeamId());
            ps.setString(2, cricketer.getCricketerName());
            ps.setInt(3, cricketer.getAge());
            ps.setString(4, cricketer.getNationality());
            ps.setInt(5, cricketer.getExperience());
            ps.setString(6, cricketer.getRole());
            ps.setInt(7, cricketer.getTotalRuns());
            ps.setInt(8, cricketer.getTotalWickets());   
            ps.setInt(9, cricketer.getCricketerId());

            int n = ps.executeUpdate();
        }
        catch(SQLException sqlEx)
        {
            //sqlEx.printStackTrace();
            throw new SQLException(sqlEx.getMessage());
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}
