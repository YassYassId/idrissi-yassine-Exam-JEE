package com.jee.idrissiyassineexamjee;

import com.jee.idrissiyassineexamjee.entities.*;
import com.jee.idrissiyassineexamjee.enums.StatusCredit;
import com.jee.idrissiyassineexamjee.enums.TypeBien;
import com.jee.idrissiyassineexamjee.enums.TypeRemboursement;
import com.jee.idrissiyassineexamjee.repositories.ClientRepository;
import com.jee.idrissiyassineexamjee.repositories.CreditRepository;
import com.jee.idrissiyassineexamjee.repositories.RemboursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class IdrissiYassineExamJeeApplication {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private RemboursementRepository remboursementRepository;

    public static void main(String[] args) {
        SpringApplication.run(IdrissiYassineExamJeeApplication.class, args);
    }

    @Bean
    public CommandLineRunner start() {
        return args -> {

            //Add Clients
            Client client1 = new Client();
            client1.setNom("Yassine IDRISSI");
            client1.setEmail("yassine@gamil.com");

            Client client2 = new Client();
            client2.setNom("Soufiane IDRISSI");
            client2.setEmail("soufiane@gmail.com");

            client1 = clientRepository.save(client1);
            client2 = clientRepository.save(client2);

            System.out.println("Added 2 clients");


            //Add Credits

            // Personal Credit
            CreditPersonnel credit1 = new CreditPersonnel();
            credit1.setDateDemande(new Date(2024, 1, 15));
            credit1.setStatus(StatusCredit.ACCEPTE);
            credit1.setDateAcceptation(new Date(2024, 1, 20));
            credit1.setMontant(10000.0);
            credit1.setDureeRemboursement(24);
            credit1.setTauxInteret(5.0);
            credit1.setMotif("Achat voiture");
            credit1.setClient(client1);

            // Real Estate Credit
            CreditImmobilier credit2 = new CreditImmobilier();
            credit2.setDateDemande(new Date(2024, 3, 10));
            credit2.setStatus(StatusCredit.EN_COURS);
            credit2.setMontant(200000.0);
            credit2.setDureeRemboursement(360);
            credit2.setTauxInteret(3.5);
            credit2.setTypeBien(TypeBien.MAISON);
            credit2.setClient(client2);

            // Professional Credit
            CreditProfessionnel credit3 = new CreditProfessionnel();
            credit3.setDateDemande(new Date(2024, 4, 5));
            credit3.setStatus(StatusCredit.REJETE);
            credit3.setMontant(50000.0);
            credit3.setDureeRemboursement(12);
            credit3.setTauxInteret(7.0);
            credit3.setMotif("Nouvelle machine");
            credit3.setRaisonSociale("Tech Innovations SARL");
            credit3.setClient(client1);

            credit1 = creditRepository.save(credit1);
            credit2 = creditRepository.save(credit2);
            credit3 = creditRepository.save(credit3);

            System.out.println("Added 3 credits");


            // Add Repayments

            Remboursement r1 = new Remboursement();
            r1.setDate(new Date(2024, 2, 1));
            r1.setMontant(400.0);
            r1.setType(TypeRemboursement.MENSUALITE);
            r1.setCredit(credit1);

            Remboursement r2 = new Remboursement();
            r2.setDate(new Date(2024, 3, 1));
            r2.setMontant(400.0);
            r2.setType(TypeRemboursement.MENSUALITE);
            r2.setCredit(credit1);

            Remboursement r3 = new Remboursement();
            r3.setDate(new Date(2024, 4, 1));
            r3.setMontant(5000.0);
            r3.setType(TypeRemboursement.REMBOURSEMENT_ANTICIPE);
            r3.setCredit(credit2);

            remboursementRepository.save(r1);
            remboursementRepository.save(r2);
            remboursementRepository.save(r3);

            System.out.println("Added 3 repayments");

        };
    }

}
