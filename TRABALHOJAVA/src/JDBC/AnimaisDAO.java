package JDBC;

import mvc.AnimaisModel.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AnimaisDAO extends BasicoDAO {
	
	public void insert(AnimaisModel animais) {

        String sql = " insert into animais(marca, modelo, cor, anomodelo) values(?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, animais.getMarca());
            statement.setString(2, animais.getModelo());
            statement.setString(3, animais.getCor());
            statement.setInt(4, animais.getAnomodelo());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(animaisModel animais) {

        String sql = " delete from animais where marca = ?";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, animais.getMarca());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(animaisModel animais) {
        String sql = " update animais set marca = ?, modelo = ?, ano = ?, anomodelo = ? where codigotarefa = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1, animais.getMarca());
            statement.setString(2, animais.getModelo());
            statement.setString(3, animais.getCor());
            statement.setInt(4, animais.getAnomodelo());
            statement.execute();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public animaisModel getByMarca(int marca) {
        animaisModel animais = null;
        String sql = " select marca, modelo, cor, anomodelo from animaisModel where marca = ?";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, String.valueOf(marca));
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                animais = new animaisModel();
                animais.setMarca(resultSet.getString(1));
                animais.setModelo(resultSet.getString(2));
                animais.setCor(resultSet.getString(3));
                animais.setAnomodelo(resultSet.getInt(4));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return animais;
    }

    public List<animaisModel> getAll(){
        List<animaisModel> list = new ArrayList<>();
        String sql = " select marca, modelo, cor, anomodelo from animaisModel order by marca";

        try(Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                animaisModel animais = new animaisModel();
                animais.setMarca(resultSet.getString(1));
                animais.setModelo(resultSet.getString(2));
                animais.setCor(resultSet.getString(3));;
                animais.setAnomodelo(resultSet.getInt(4));


                list.add(animais);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
}
