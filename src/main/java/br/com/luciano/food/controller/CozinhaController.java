package br.com.luciano.food.controller;

import br.com.luciano.food.domain.entity.CozinhaEntity;
import br.com.luciano.food.domain.jpa.impl.CozinhaImpl;
import br.com.luciano.food.domain.model.Cozinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cozinhas")
@ResponseBody
public class CozinhaController {

    @Autowired
    CozinhaImpl cozinhaImpl;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE })
    public List<CozinhaEntity> findAll() {
        return this.cozinhaImpl.findAll();
    }

}
