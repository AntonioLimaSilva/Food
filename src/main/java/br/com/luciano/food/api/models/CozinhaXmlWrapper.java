package br.com.luciano.food.api.models;

import br.com.luciano.food.domain.entities.CozinhaEntity;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

//@JsonRootName("cozinhas")
@JacksonXmlRootElement(localName = "cozinhas")
@Data
public class CozinhaXmlWrapper {


    @JacksonXmlProperty(localName = "cozinha")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NonNull
    private List<CozinhaEntity> cozinhaEntities;

}
