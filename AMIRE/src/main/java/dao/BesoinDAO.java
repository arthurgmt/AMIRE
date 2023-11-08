package dao;

import beans.BesoinBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import models.Besoin;

import java.util.List;

@ApplicationScoped
public class BesoinDAO {
    @EJB
    private BesoinBean besoinBean;

    public void addBesoin(Besoin besoin) {
        besoinBean.addBesoin(besoin);
    }

    public void updateBesoin(Besoin besoin) {
        besoinBean.updateBesoin(besoin);
    }

    public void deleteBesoin(int id) {
        besoinBean.deleteBesoin(id);
    }

    public List<Besoin> getAllBesoins() {
        return besoinBean.getAllBesoins();
    }

    public Besoin getBesoinById(int id) {
        return besoinBean.getBesoinById(id);
    }

    public List<Besoin> getBesoinsByEcoleID(int id) {
        return besoinBean.getBesoinsByEcoleID(id);
    }

    public List<Besoin> getBesoinsByEcoleName(String name) {
        return besoinBean.getBesoinsByEcoleName(name);
    }
}
