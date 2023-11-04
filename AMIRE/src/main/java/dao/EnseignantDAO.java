package dao;

import models.Enseignant;
import util.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnseignantDAO {

    public List<Enseignant> getAllEnseignants() {
        List<Enseignant> enseignants = new ArrayList<>();
        String sql = "SELECT * FROM Enseignant";
        try (Connection conn = DatabaseConfiguration.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Enseignant enseignant = new Enseignant();
                enseignant = mapResultSetToEnseignant(rs);
                enseignants.add(enseignant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;
    }

    public Enseignant getEnseignantById(int id) {
        Enseignant enseignant = null;
        String sql = "SELECT * FROM Enseignant WHERE ID = ?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                enseignant = mapResultSetToEnseignant(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignant;
    }

    public void addEnseignant(Enseignant enseignant) {
        String sql = "INSERT INTO Enseignant(ID, UtilisateurID, Experience, Telephone, SiteWeb, NiveauxSouhaites, Disponibilites, TypeContrat, TitresAcademiques, Evaluations, AutresInformations) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enseignant.getID());
            stmt.setInt(2, enseignant.getUtilisateurID());
            stmt.setInt(3, enseignant.getExperience());
            stmt.setString(4, enseignant.getTelephone());
            stmt.setString(5, enseignant.getSiteWeb());
            stmt.setString(6, enseignant.getNiveauxSouhaites());
            stmt.setDate(7, new java.sql.Date(enseignant.getDisponibilites().getTime()));
            stmt.setString(8, enseignant.getTypeContrat());
            stmt.setString(9, enseignant.getTitresAcademiques());
            stmt.setString(10, enseignant.getEvaluations());
            stmt.setString(11, enseignant.getAutresInformations());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEnseignant(Enseignant enseignant) {
        String sql = "UPDATE Enseignant SET UtilisateurID=?, Experience=?, Telephone=?, SiteWeb=?, NiveauxSouhaites=?, Disponibilites=?, TypeContrat=?, TitresAcademiques=?, Evaluations=?, AutresInformations=? WHERE ID=?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, enseignant.getUtilisateurID());
            stmt.setInt(2, enseignant.getExperience());
            stmt.setString(3, enseignant.getTelephone());
            stmt.setString(4, enseignant.getSiteWeb());
            stmt.setString(5, enseignant.getNiveauxSouhaites());
            stmt.setDate(6, new java.sql.Date(enseignant.getDisponibilites().getTime()));
            stmt.setString(7, enseignant.getTypeContrat());
            stmt.setString(8, enseignant.getTitresAcademiques());
            stmt.setString(9, enseignant.getEvaluations());
            stmt.setString(10, enseignant.getAutresInformations());
            stmt.setInt(11, enseignant.getID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEnseignant(int id) {
        String sql = "DELETE FROM Enseignant WHERE ID=?";
        try (Connection conn = DatabaseConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Enseignant mapResultSetToEnseignant(ResultSet rs) throws SQLException {
        int ID = (rs.getInt("ID"));
        int utilisateurID = (rs.getInt("UtilisateurID"));
        Integer experience = (rs.getInt("Experience"));
        String telephone = (rs.getString("Telephone"));
        String siteweb = (rs.getString("SiteWeb"));
        String niveau = (rs.getString("NiveauxSouhaites"));
        Date disponibilite = (rs.getDate("Disponibilites"));
        String typecontrat = (rs.getString("TypeContrat"));
        String titreacademique = (rs.getString("TitresAcademiques"));
        String evalutations = (rs.getString("Evaluations"));
        String autres = (rs.getString("AutresInformations"));
        Enseignant enseignant = new Enseignant(ID, utilisateurID, experience, telephone, siteweb, niveau, disponibilite, typecontrat, titreacademique, evalutations, autres);
        return enseignant;
    }
}
