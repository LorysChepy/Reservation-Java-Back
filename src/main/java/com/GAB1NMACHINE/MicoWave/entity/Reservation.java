import com.GAB1NMACHINE.MicoWave.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public boolean isReserved() {
    boolean reserved = false;
    return reserved;
}

public User getReservedBy() {
    User reservedBy = null;
    return reservedBy;
}

public void setReservedBy(User reservedBy) {
    this.reservedBy = reservedBy;
}


private User reservedBy;

public void main() {
}
