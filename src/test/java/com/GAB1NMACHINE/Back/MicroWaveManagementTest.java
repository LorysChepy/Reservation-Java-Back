package com.GAB1NMACHINE.Back;

import com.GAB1NMACHINE.MicoWave.entity.MicroWave;
import com.GAB1NMACHINE.MicoWave.entity.User;
import com.GAB1NMACHINE.MicoWave.manager.MicroWaveManagement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MicroWaveManagementTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private MicroWaveManagement microWaveManagement;

    @BeforeEach
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("test-pu");
        em = emf.createEntityManager();

        // Créer des micro-ondes pour les tests
        MicroWave microWave1 = new MicroWave();
        MicroWave microWave2 = new MicroWave();
        MicroWave microWave3 = new MicroWave();

        em.getTransaction().begin();
        em.persist(microWave1);
        em.persist(microWave2);
        em.persist(microWave3);
        em.getTransaction().commit();

        List<MicroWave> microWaves = List.of(microWave1, microWave2, microWave3);
        microWaveManagement = new MicroWaveManagement(microWaves);

        System.out.println("Setup completed. MicroWaves persisted: " + microWaves.size());
    }

    @Test
    public void testReserveMicroWave() {
        User user = new User();
        user.setName("John Doe");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        System.out.println("User persisted: " + user.getName());

        // Ajouter une réservation de micro-ondes et vérifier les résultats
        // Ici, vous devrez ajouter l'appel à la méthode de réservation et afficher les résultats

        // Exemple (supposant que vous avez une méthode de réservation) :
        // LocalDateTime desiredStartTime = LocalDateTime.of(2024, 5, 17, 10, 0);
        // int cookingTime = 15; // 15 minutes
        // String result = microWaveManagement.reserveMicroWave(user, cookingTime, desiredStartTime);
        // System.out.println("Reservation result: " + result);
        // assertTrue(result.contains("John Doe a réservé le micro-ondes"));
    }
}
