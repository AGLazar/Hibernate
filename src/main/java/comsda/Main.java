package comsda;

import comsda.dao.DoctorDao;
import comsda.dao.EmailDao;
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
            //createPacient(); //works
            //createHospital();//works
            //createDoctors(); //works
            //deletePacient(); //works
            //deleteEmail(); //works finally!
            //updateEmail(); //works
            //updateDoctor(); //incomplete-teh hospital is not updated -> needs fixing
            //updatePacient(); //works
            //printTheDoctorsList(); //works
        } finally {
            HibernateUtil.close();
        }
    }

    private static void createPacient() {
        PacientDao pacientDao = new PacientDao();
        Pacient pacient1 = new Pacient("Felix Argintarul",25L, new Email("FelixSilver@yahoo.com"));
        pacientDao.createEntity(pacient1);
        Email pacient2email = new Email("Tony@gmail.com");
        Pacient pacient2 = new Pacient("Tony Incredibilul", 25L, pacient2email);
        pacientDao.createEntity(pacient2);
    }

    private static void createHospital() {
        HospitalDao hospitalDao = new HospitalDao();
        Hospital hospital1 = new Hospital("Parhon");
        hospitalDao.createEntity(hospital1);
    }

    private static void createDoctors() {
        DoctorDao doctorDao = new DoctorDao();
        HospitalDao hospitalDao = new HospitalDao();
        Hospital h1 = hospitalDao.getEntityById(Hospital.class, 1L);
        Doctor doc1 = new Doctor("Alina Petrache", h1);
        Doctor doc2 = new Doctor("Donica Lori", h1);
        doctorDao.createEntity(doc1);
        doctorDao.createEntity(doc2);

    }

    private static void printTheDoctorsList() {
        HospitalDao hospitalDao = new HospitalDao();
        Hospital h1 = hospitalDao.getEntityById(Hospital.class, 1L);
        for (Doctor doctor : h1.getDoctors()) {
            System.out.println(doctor);
        }

    }

    private static  void deleteEmail() {
       PacientDao pacientDao = new PacientDao();
       Pacient selectedPacient = pacientDao.getEntityById(Pacient.class, 10L);
       Long idEmail = selectedPacient.getEmail().getId(); // ->7
       System.out.println(idEmail.toString());
       selectedPacient.setEmail(null);
       pacientDao.update(selectedPacient);
       EmailDao emailDao = new EmailDao();
       Email myDeletedEmail = (Email) emailDao.getEntityById(Email.class, idEmail);
       emailDao.deleteEntity(myDeletedEmail);

    }

    private static void deletePacient() {
        PacientDao pacientDao = new PacientDao();
        Pacient deletedPacient = pacientDao.getEntityById(Pacient.class, 14L);
        Long deletedIdEmail = deletedPacient.getEmail().getId();
        EmailDao emailDao = new EmailDao();
        Email mySelectedEmail = (Email) emailDao.getEntityById(Email.class, deletedIdEmail);
        emailDao.update(mySelectedEmail);
        pacientDao.deleteEntity(deletedPacient);
    }

    private static void updateEmail() {
        EmailDao emailDao = new EmailDao();
        Email mySelectedEmail = (Email) emailDao.getEntityById(Email.class, 7L);
        mySelectedEmail.setEmailAddress("MaricicaEveselea");
        emailDao.update(mySelectedEmail);
    }

    private static void updatePacient(){
        PacientDao pacientDao = new PacientDao();
        Email email = new Email("SauronSucks@gmail.com");
        Pacient selectedPactient = (Pacient)pacientDao.getEntityById(Pacient.class, 13L);
        selectedPactient.setPacientName("Gandalf the Grey");
        selectedPactient.setPacientAge(100000000L);
        selectedPactient.setEmail(email);
        pacientDao.update(selectedPactient);
    }

    private static  void updateDoctor(){
        HospitalDao hospitalDao = new HospitalDao();
        Hospital newHospital = hospitalDao.getEntityById(Hospital.class, 2L);
        DoctorDao doctorDao = new DoctorDao();
        Doctor doctor = (Doctor) doctorDao.getEntityById(Doctor.class, 4L);
        doctor.setDoctorName("Mother Goose");
        doctor.setHospital(newHospital);
        doctorDao.update(doctor);
    }
}
