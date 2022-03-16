package repository;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.AccountDataStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperation {
    private static final EntityManagerFactory entityManagerFactor =
            Persistence.createEntityManagerFactory("ro.travelling_agency.assignment_one.SD");


    public void insertUserAccount(VacaySeeker user) {
       EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();

    }
    public void insertDestination(VacationDestination destination) {
        EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        em.persist(destination);
        em.getTransaction().commit();
        em.close();

    }
    public void insertVacationPackage(VacationPackage vacationPackage) {
        EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        em.persist(vacationPackage);
        em.getTransaction().commit();
        em.close();

    }


    public void editVacationPackage(VacationPackage vp) {
       EntityManager em = entityManagerFactor.createEntityManager();
       em.getTransaction().begin();
       em.unwrap(Session.class).update(vp);
       em.getTransaction().commit();
       em.close();



    }
    public void deleteVacationPackage(String name){
        EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE from VacationPackage u where u.name=:name");
        query.setParameter("name",name);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }


public VacaySeeker findUserByCredentials(String usernameOrEmail, String pass) {
    EntityManager em = entityManagerFactor.createEntityManager();
    em.getTransaction().begin();
    try {
        return em.createQuery("SELECT u from VacaySeeker u WHERE (u.username = :username OR u.email = :email) AND u.password = :password", VacaySeeker.class).
                setParameter("username", usernameOrEmail).
                setParameter("email", usernameOrEmail).
                setParameter("password", pass).getSingleResult();


    } catch (NoResultException e) {
        System.out.println("No user found by provided credentials.");

    }
    em.getTransaction().commit();
    em.close();
return  null;

}
    public AccountDataStatus findTravellingAgencyByCredentials(String usernameOrEmail, String password) {
        EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("SELECT u from TravellingAgency u WHERE (u.username = :username OR u.email = :email) AND u.password =:password", TravellingAgency.class).
                    setParameter("username", usernameOrEmail).
                    setParameter("email", usernameOrEmail).
                    setParameter("password", password).getSingleResult();
            em.getTransaction().commit();
            em.close();
            return AccountDataStatus.VALID;

        } catch (NoResultException e) {
            System.out.println("No user found by provided credentials.");
            em.getTransaction().commit();
            em.close();
            return AccountDataStatus.WRONG_CREDENTIALS;
        }

    }
    public List<Country> getCountriesFromDatabase() {
        EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT u from Country u ", Country.class).getResultList();


        } catch (NoResultException e) {
            System.out.println("No countries available.");

        }

        em.getTransaction().commit();
        em.close();
        return  null;

    }
    public List<VacationDestination> getDestinationsFromDatabase() {
        EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT u from VacationDestination u ", VacationDestination.class).getResultList();


        } catch (NoResultException e) {
            System.out.println("No destinations available.");

        }

        em.getTransaction().commit();
        em.close();
        return  null;

    }
    public List<VacationPackage> getVacationPackagesFromDatabase(){
        EntityManager em = entityManagerFactor.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT u from VacationPackage u ", VacationPackage.class).getResultList();

        } catch (NoResultException e) {
            System.out.println("No packages available.");

        }

        em.getTransaction().commit();
        em.close();
        return  null;
    }



}

