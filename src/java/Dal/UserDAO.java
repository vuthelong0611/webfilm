/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.country;
import Model.film;
import Model.type;
import Model.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class UserDAO extends DBContext {

    public user getUser(String user, String pass) {
        String sql = "select * from Account where name_ = ? and pass_ = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user c = new user(rs.getString("name_"), rs.getString("pass_"), rs.getString("nickname"), rs.getInt("role"), rs.getInt("id"));
                return c;
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
//     public List<user> getAll() {
//        List<user> list = new ArrayList<>();
//        String sql = "select * from user_cus";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                user c = new user(rs.getInt("id"), rs.getString("name_cus"), rs.getString("pass_cus"));
//                list.add(c);
//            }
//        } catch (SQLException e) {
//            System.err.println(e);
//        }
//        return list;
//    }

    public void updateAccount(int id, String u, String p, String n) {

        String sql = "UPDATE Account\n"
                + "   SET [name_] = ?\n"
                + "      ,[pass_] = ?\n"
                + "      ,[nickname] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            st.setString(2, p);
            st.setString(3, n);
            st.setInt(4, id);
            st.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public void updateFilm(int id, String name, String img, String video, String type, String country, int view) {

        String sql = "UPDATE film\n"
                + "   SET [name_] = ?\n"
                + "      ,[img] = ?\n"
                + "      ,[video] = ?\n"
                + "      ,[view] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, name);
            st.setString(2, img);
            st.setString(3, video);

            st.setInt(4, view);
            st.setInt(5, id);

            st.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public void delete(int name) {
        String sql = "DELETE FROM [dbo].[film]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, name);

            st.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void delete1(int name) {
        String sql = "DELETE FROM [dbo].[film]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, name);

            st.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void insertU(user u) {
        String sql = "INSERT INTO Account (name_,pass_,role,nickname) values (?,?,2,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, u.getName());
            st.setString(2, u.getPass());
            st.setString(3, u.getNickname());

            st.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void insertF(film f) {
        String sql = "INSERT INTO film (name_,img,video) values (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, f.getName());
            st.setString(2, f.getImg());
            st.setString(3, f.getVideo());

            st.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public List<country> getCountry() {
        List<country> list = new ArrayList<>();
        String sql = "select * from country";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                country f = new country(rs.getInt("id"), rs.getString("name_"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public film getfilm(int id) {

        String sql = "select * from film where id= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                return f;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public film getfilmmax() {
        List<film> list = new ArrayList<>();
        String sql = "select * from film where [view] = (SELECT Max([view]) \n"
                + "FROM film); ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                return f;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public film getfilmmin() {
        List<film> list = new ArrayList<>();
        String sql = "select * from film where [view] = (SELECT Min([view]) \n"
                + "FROM film); ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                return f;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public int allviews() {
        String sql = "select sum([view]) as sum from film ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int sum = rs.getInt("sum");
                return sum;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public int avgviews() {
        String sql = "select avg([view]) as avg from film ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int sum = rs.getInt("avg");
                return sum;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public int countfilm() {
        String sql = "select count([name_]) as count from film ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int sum = rs.getInt("count");
                return sum;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public List<film> getfilm() {
        List<film> list = new ArrayList<>();
        String sql = "select * from film";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }
        public List<film> getfilmASC() {
        List<film> list = new ArrayList<>();
        String sql = "select * from film order by name_ asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }
                public List<film> getfilmDsc() {
        List<film> list = new ArrayList<>();
        String sql = "select * from film order by name_ desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }


    public List<film> getfilmHDUSA() {
        List<film> list = new ArrayList<>();
        String sql = "select * from film where type= 'hanhdong' and country='USA'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view_"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<film> getfilmnew() {
        List<film> list = new ArrayList<>();
        String sql = "select top 6 * from film desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view_"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<film> getfilmHDview() {
        List<film> list = new ArrayList<>();
        String sql = "select top 6 f.* from film as f join film_type as t on f.id = t.f_id join type_ as t1\n"
                + "                on t.t_id = t1.id where t1.id = 1 order by f.[view] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<film> getfilmHHview() {
        List<film> list = new ArrayList<>();
        String sql = "select top 6 f.* from film as f join film_type as t on f.id = t.f_id join type_ as t1\n"
                + "                on t.t_id = t1.id where t1.id = 2 order by f.[view] desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<film> getfilmview() {
        List<film> list = new ArrayList<>();
        String sql = "select top 6 * from film order by [view] DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public void updatePass(String name, String pass) {

        String sql = "UPDATE Account SET pass_ = ? WHERE name_ = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, name);

            st.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public user getC(String u) {

        String sql = "select * from Account where name_ = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user c = new user(rs.getString("name_"), rs.getString("pass_"), rs.getString("nickname"), rs.getInt("role"), rs.getInt("id"));
                return c;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public List<film> getfilmHD(int type) {
        List<film> list = new ArrayList<>();
        String sql = "select f.* from film as f join film_type as t on f.id = t.f_id join type_ as t1\n"
                + "on t.t_id = t1.id where t1.id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<String> gettype(int type) {
        List<String> list = new ArrayList<>();
        String sql = "select t1.name_ as a from film as f join film_type as t on f.id = t.f_id join type_ as t1 on t.t_id = t1.id where f.id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String f = rs.getString("a");
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<film> getfilmCT(int type) {
        List<film> list = new ArrayList<>();
        String sql = "select f.* from film as f join film_country as t on f.id = t.f_id join country as t1\n"
                + "                on t.c_id = t1.id where t1.id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, type);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<film> getSbyName(String name) {
        String sql = "select * from film where name_ like ?";
        List<film> list = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<film> getPaging(int index) {
        String sql = "select * from film order by id offset ? rows fetch next 6 rows only";
        List<film> list = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index - 1) * 6);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public void insertFav(int idU, int idF) {
        String sql = "INSERT INTO favourite (u_id,f_id) values (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idU);
            st.setInt(2, idF);

            st.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public List<film> getFilmFav(int id) {
        String sql = "select * from film join favourite on film.id = favourite.f_id join account on account.id = favourite.u_id where account.id=?";
        List<film> list = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public film getSbyId(int name) {
        String sql = "select * from film where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                film f = new film(rs.getInt("id"), rs.getString("name_"), rs.getString("img"), rs.getString("video"), rs.getInt("view"));
                return f;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public List<type> getAllType() {
        String sql = "select * from type_";
        List<type> list = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                type f = new type(rs.getInt("id"), rs.getString("name_"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public List<country> getAllCountry() {
        String sql = "select * from country";
        List<country> list = new ArrayList<>();

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                country f = new country(rs.getInt("id"), rs.getString("name_"));
                list.add(f);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        UserDAO c = new UserDAO();

        c.insertT("USAa");

    }

    public void upDateCT(int id, String name) {
        String sql = "UPDATE Country\n"
                + "   SET [name_] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);
            st.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public country getcountry(int id) {
        String sql = "select * from country where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                country f = new country(rs.getInt("id"), rs.getString("name_"));
                return f;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public type getT(int id) {
        String sql = "select * from type_ where id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                type f = new type(rs.getInt("id"), rs.getString("name_"));
                return f;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public void upDateT(int id, String name) {
        String sql = "UPDATE type_\n"
                + "   SET [name_] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);
            st.execute();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void insertCT(String name) {
        String sql = "INSERT INTO country (name_) values (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, name);

            st.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void insertT(String name) {
        String sql = "INSERT INTO type_ (name_) values (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, name);

            st.execute();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
