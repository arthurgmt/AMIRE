package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Utilisateur;
import util.DatabaseConfiguration;

public class UtilisateurDAO {

    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try (Connection conn = DatabaseConfiguration.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur");
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setID(rs.getInt("ID"));
                utilisateur.setNom(rs.getString("Nom"));
                // ... set autres attributs
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    // ... autres méthodes pour INSERT, UPDATE, DELETE, etc.
}
