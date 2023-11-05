package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                utilisateur.setPrenom(rs.getString("Prenom"));
                utilisateur.setMail(rs.getString("Mail"));
                utilisateur.setMotDePasse(rs.getString("MotDePasse"));
                utilisateur.setRole(rs.getString("Role"));

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    public Utilisateur getUserById(int id) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM Utilisateur WHERE ID = ?";

        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setID(rs.getInt("ID"));
                utilisateur.setNom(rs.getString("Nom"));
                utilisateur.setPrenom(rs.getString("Prenom"));
                utilisateur.setMail(rs.getString("Mail"));
                utilisateur.setMotDePasse(rs.getString("MotDePasse"));
                utilisateur.setRole(rs.getString("Role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    public void addUser(Utilisateur utilisateur) {
        String SQL = "INSERT INTO Utilisateur(Nom, Prenom, Mail, MotDePasse, Role) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getMail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getRole());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Utilisateur utilisateur) {
        String SQL = "UPDATE Utilisateur SET Nom=?, Prenom=?, Mail=?, MotDePasse=?, Role=? WHERE ID=?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getMail());
            stmt.setString(4, utilisateur.getMotDePasse());
            stmt.setString(5, utilisateur.getRole());
            stmt.setInt(6, utilisateur.getID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String SQL = "DELETE FROM Utilisateur WHERE ID=?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Utilisateur login(String mail, String password) {
        String SQL = "SELECT * FROM Utilisateur WHERE Mail=? AND MotDePasse=?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, mail);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setID(rs.getInt("ID"));
                utilisateur.setNom(rs.getString("Nom"));
                utilisateur.setPrenom(rs.getString("Prenom"));
                utilisateur.setMail(rs.getString("Mail"));
                utilisateur.setMotDePasse(rs.getString("MotDePasse"));
                utilisateur.setRole(rs.getString("Role"));
                return utilisateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}