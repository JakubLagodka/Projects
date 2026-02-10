package it.unipol.crm.attivita.model;

import it.unipol.crm.attivita.persistence.model.Attivita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsertAttivitaWithConfigResponse {

    private List<Attivita> attivitaList;
}
