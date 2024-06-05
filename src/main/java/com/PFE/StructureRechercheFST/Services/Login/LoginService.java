package com.PFE.StructureRechercheFST.Services.Login;

import com.PFE.StructureRechercheFST.DAO.AdminDAO;
import com.PFE.StructureRechercheFST.DAO.DoctorantDAO;
import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.Services.RandomPasswordGenerator;
import com.PFE.StructureRechercheFST.models.Admin;
import com.PFE.StructureRechercheFST.models.Doctorant;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Publication;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class LoginService {
    @Autowired
   private EnseignantDAO enseignantDAO;
    @Autowired
   private DoctorantDAO doctorantDAO;
    @Autowired
    private AdminDAO adminDAO;
    @Value("${spring.mail.username}")
    private String fromEmail;
    @Autowired
    private JavaMailSender javaMailSender;
    //    @Autowired
//   private AdministrateurDAO administrateurDAO;
    public Doctorant connectDoctorant(String email, String password){
       Doctorant doctorant = doctorantDAO.findDoctorantByEmailAndPassword(email, password);
        if(doctorant != null) {
            doctorant.getEncadrant().setDoctorants(null);
            doctorant.setEncadrant(null);
        }

//     doctorant.setPublications(null);
       return doctorant;
    }
    public Enseignant connectEnseignant(String email, String password) {
        Enseignant enseignant = enseignantDAO.findEnseignantByEmailAndPassword(email, password);
        List<Publication> enseignantPubs = enseignant.getPublications();
        enseignantPubs.forEach(p->{
            p.setEnseignant(null);
        });
        List<Doctorant> enseignantDocs = enseignant.getDoctorants();
        enseignantDocs.forEach(d->{
            d.setEncadrant(null);
        });
        enseignant.getEquipe().setMembres(null);
        enseignant.getEquipe().setThemes(null);
        enseignant.getEquipe().setResponsable(null);
        enseignant.getLabo().setMembresLabo(null);
        enseignant.getLabo().setThemes(null);
        enseignant.getLabo().setResponsable(null);
        return enseignant;
    }
    public Admin connectAdmin(String email, String password) {
        Admin admin = adminDAO.findAdminByEmailAndPassword(email, password);
        return admin;
    }
    public Object newPassword(String email){
        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        String userName = null;
        String newPassword = null;
        Enseignant enseignant = enseignantDAO.findEnseignantByEmail(email);
        Doctorant doctorant = doctorantDAO.findDoctorantByEmail(email);
        Admin admin = adminDAO.findAdminByEmail(email);
        Object object = null;
        if(enseignant != null){
            enseignant.setEquipe(null);
            enseignant.setPublications(null);
            enseignant.setDoctorants(null);
            newPassword = randomPasswordGenerator.generatePassword(10);
            enseignant.setPassword(newPassword);
            userName = enseignant.getNom()+" "+enseignant.getPrenom();
            enseignantDAO.save(enseignant);
            object = enseignant;
        } else if (doctorant != null) {
            doctorant.setEncadrant(null);
            newPassword = randomPasswordGenerator.generatePassword(10);
            doctorant.setPassword(newPassword);
            userName = doctorant.getNom()+" "+doctorant.getPrenom();
            doctorantDAO.save(doctorant);
            object = doctorant;
        }else {
            newPassword = randomPasswordGenerator.generatePassword(10);
            admin.setPassword(newPassword);
            userName = admin.getNom()+" "+admin.getPrenom();
            adminDAO.save(admin);
            object = admin;
        }
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("Le mot de passe oublier!");
            mimeMessageHelper.setText("Bonjour M. "+userName+" votre nouveau mot de passe est : "+newPassword);
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
        return object;
    }
}
