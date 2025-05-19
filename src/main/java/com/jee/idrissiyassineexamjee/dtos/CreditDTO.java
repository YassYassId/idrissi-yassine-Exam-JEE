package com.jee.idrissiyassineexamjee.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private String status;
    private Date DateAcceptation;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;
    private String motif;
    private String raisonSociale;
    private String typeBien;
    private Long clientId;
}
