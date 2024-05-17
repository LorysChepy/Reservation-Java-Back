package repository;

import com.GAB1NMACHINE.MicoWave.entity.MicroWave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroWaveRepository extends JpaRepository<MicroWave, Long> {
}
