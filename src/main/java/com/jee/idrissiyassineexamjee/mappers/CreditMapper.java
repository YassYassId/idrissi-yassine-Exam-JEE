package com.jee.idrissiyassineexamjee.mappers;

import com.jee.idrissiyassineexamjee.dtos.CreditDTO;
import com.jee.idrissiyassineexamjee.entities.Credit;
import com.jee.idrissiyassineexamjee.entities.CreditImmobilier;
import com.jee.idrissiyassineexamjee.entities.CreditPersonnel;
import com.jee.idrissiyassineexamjee.entities.CreditProfessionnel;
import org.springframework.stereotype.Service;

@Service
public class CreditMapper {
    public CreditDTO toDTO(Credit credit) {
        if (credit == null) return null;

        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatus(credit.getStatus().name());
        dto.setDateAcceptation(credit.getDateAcceptation());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());

        if (credit.getClient() != null) {
            dto.setClientId(credit.getClient().getId());
        }

        if (credit instanceof CreditPersonnel cp) {
            dto.setMotif(cp.getMotif());
        } else if (credit instanceof CreditImmobilier ci) {
            dto.setTypeBien(ci.getTypeBien().name());
        } else if (credit instanceof CreditProfessionnel cpro) {
            dto.setMotif(cpro.getMotif());
            dto.setRaisonSociale(cpro.getRaisonSociale());
        }

        return dto;
    }
}
