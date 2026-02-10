package it.unipol.crm.sinistro.model.sinistro;

import it.unipol.crm.sinistro.model.Paginazione;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SinistroPaginatoRisp {

    private Paginazione paginazione;
    private List<SinistroRisp> sinistri;
}
