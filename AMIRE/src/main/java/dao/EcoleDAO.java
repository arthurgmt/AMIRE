package dao;

import models.Ecole;
import util.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EcoleDAO {

    public List<Ecole> getAllEcoles() {
        List<Ecole> ecoles = new ArrayList<>();
        String sql = "SELECT * FROM Ecole";
        try (Connection conn = DatabaseConfiguration.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ecole ecole = new Ecole();
                ecole.setID(rs.getInt("ID"));
                ecole.setUtilisateurID(rs.getInt("UtilisateurID"));
                ecole.setRaisonSociale(rs.getString("RaisonSociale"));
                ecole.setAdresse(rs.getString("Adresse"));
                ecole.setSiteWeb(rs.getString("SiteWeb"));
                ecole.setContact(rs.getString("Contact"));
                ecoles.add(ecole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ecoles;
    }

    public Ecole getEcoleById(int id) {
        Ecole ecole = null;
        String sql = "SELECT * FROM Ecole WHERE ID = ?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                ecole = new Ecole();
                ecole.setID(rs.getInt("ID"));
                ecole.setRaisonSociale(rs.getString("RaisonSociale"));
                ecole.setAdresse(rs.getString("Adresse"));
                ecole.setSiteWeb(rs.getString("SiteWeb"));
                ecole.setContact(rs.getString("Contact"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ecole;
    }

    public void addEcole(Ecole ecole) {
        String sql = "INSERT INTO Ecole (RaisonSociale, Adresse, SiteWeb, Contact) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, ecole.getRaisonSociale());
            stmt.setString(2, ecole.getAdresse());
            stmt.setString(3, ecole.getSiteWeb());
            stmt.setString(4, ecole.getContact());
    
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateEcole(Ecole ecole) {
        String sql = "UPDATE Ecole SET UtilisateurID = ?, RaisonSociale = ?, Adresse = ?, SiteWeb = ?, Contact = ? WHERE ID = ?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, ecole.getUtilisateurID()); 
            stmt.setString(2, ecole.getRaisonSociale());
            stmt.setString(3, ecole.getAdresse());
            stmt.setString(4, ecole.getSiteWeb());
            stmt.setString(5, ecole.getContact());
            stmt.setInt(6, ecole.getID());
    
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEcole(int id) {
        String sql = "DELETE FROM Ecole WHERE ID = ?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
