package com.jee.idrissiyassineexamjee.mappers;

import com.jee.idrissiyassineexamjee.dtos.RemboursementDTO;
import com.jee.idrissiyassineexamjee.entities.Remboursement;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class RemboursementMapper {
    public RemboursementDTO toDTO(Remboursement r) {
        if (r == null) return null;
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(r.getId());
        dto.setDate(r.getDate());
        dto.setMontant(r.getMontant());
        dto.setType(r.getType().name());
        if (r.getCredit() != null) dto.setCreditId(r.getCredit().getId());
        return dto;
    }

    public List<RemboursementDTO> toDTOs(List<Remboursement> remboursements) {
        return remboursements.stream().map(this::toDTO).toList();
    }
}
