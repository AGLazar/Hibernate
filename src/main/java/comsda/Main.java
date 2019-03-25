package comsda;

import comsda.dao.DoctorDao;
import comsda.dao.HospitalDao;
import comsda.dao.PacientDao;
import comsda.model.Doctor;
import comsda.model.Email;
import comsda.model.Hospital;
import comsda.model.Pacient;
import comsda.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        try {
            //createPacient();
            //createHospital();
            //createDoctors();
            printTheDoctorsList();
            //deletePacient();
        } finally {
            HibernateUtil.close();
        }
    }

    private static void createPacient() {
        PacientDao pacientDao = new PacientDao();
        //Pacient pacient1 = new Pacient("Oprescu Vasile",15l);
        //pacientDao.createEntity(pacient1);
        Email pacient2email = new Email("ImescuCarmen@gmail.com");
        Pacient pacient2 = new Pacient("Imescu Carmen", 25L, pacient2email);
        pacientDao.createEntity(pacient2);
    }

    private static void createHospital(){
        HospitalDao hospitalDao = new HospitalDao();
        Hospital hospital1 = new Hospital("Parhon");
        hospitalDao.createEntity(hospital1);
    }

    private static void createDoctors(){
        DoctorDao doctorDao = new DoctorDao();
        HospitalDao hospitalDao = new HospitalDao();
        Hospital h1 = hospitalDao.getEntityById(Hospital.class, 1L);
        Doctor doc1 = new Doctor("Popescu",h1 );
        Doctor doc2 = new Doctor("Versanu" ,h1);
        doctorDao.createEntity(doc1);
        doctorDao.createEntity(doc2);

    }

    private static void printTheDoctorsList(){
        HospitalDao hospitalDao = new HospitalDao();
        Hospital h1 = hospitalDao.getEntityById(Hospital.class,1L );
        for(Doctor doctor : h1.getDoctors()){
            System.out.println(doctor);
        }
        
    }

    private static void deletePacient(){
        PacientDao pacientDao = new PacientDao();
        pacientDao.deleteEntity(pacientDao.getEntityById(Pacient.class,8L));
    }
}
