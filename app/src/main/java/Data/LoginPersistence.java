package Data;

import Business.Patient;
//import Business.Arzt; TODO: Later implement the Login also for Arzt
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class LoginPersistence extends GenericPersistence<Patient, Long>{
    //we inherit the basic CRUD operations from the GenericRepository

    private static final Logger logger = LogManager.getLogger(LoginPersistence.class);
    private static LoginPersistence singleton;

    //returns the current instance of ChallengePersistence
    public static LoginPersistence getInstance() {
        if (singleton == null) {
            singleton = new LoginPersistence();
        }
        return singleton;
    }

    @Override
    public Patient getById(Long id) {
        return super.getByID(id);
    }

}
