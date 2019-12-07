package br.com.luciano.food.api.controllers;

import br.com.luciano.food.domain.entities.CozinhaEntity;
import br.com.luciano.food.infrastructure.specifications.ObjectSpecifications;
import br.com.luciano.food.api.models.Cozinha;
import br.com.luciano.food.api.models.CozinhaXmlWrapper;
import br.com.luciano.food.domain.repositories.CozinhaRepository;
import br.com.luciano.food.domain.services.CozinhaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/cozinhas")
@ResponseBody
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CozinhaService cozinhaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CozinhaEntity> findAll() {
        return this.cozinhaRepository.findAll();
    }

    @GetMapping(value = "/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CozinhaEntity> find(@PathVariable String nome) {
        return this.cozinhaRepository.findAll(ObjectSpecifications.withName(nome));
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXmlWrapper cozinhaXmlWrapper() {
        return new CozinhaXmlWrapper(cozinhaRepository.findAll());
    }

//    @GetMapping("/{nome}")
//    public DeferredResult<ResponseEntity<String>> async(@PathVariable String nome) {
//        System.out.println("Received async");
//        DeferredResult<ResponseEntity<String>> output = new DeferredResult<>();
//
//        new Thread(() -> {
//            System.out.println("Executando processo paralelo");
//        }).start();
//
//        System.out.println("servlet thread freed");
//
//        return output;
//
//    }

    @PostMapping
    public ResponseEntity<Cozinha> create(@RequestBody Cozinha cozinha) {
        Cozinha cozinhaSave = this.cozinhaService.execute(cozinha);

        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaSave);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateFiled(@PathVariable Long id, @RequestBody Map<String, Object> dadosOrigem) {
        Optional<CozinhaEntity> cozinhaEntity = this.cozinhaRepository.findById(id);
        System.out.println(">>>>> " + dadosOrigem);

        ObjectMapper objectMapper = new ObjectMapper();
        CozinhaEntity cozinhaOrigem = objectMapper.convertValue(dadosOrigem, CozinhaEntity.class);

        dadosOrigem.forEach((k, v) -> {

            Field campo = ReflectionUtils.findField(CozinhaEntity.class, k);
            if(campo != null)
                campo.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(campo, cozinhaOrigem);

            System.out.println("Campo: " + campo + " novo valor:  " + novoValor);

            ReflectionUtils.setField(campo, cozinhaEntity, novoValor);

        });

        System.out.println("Nome: " + cozinhaEntity.get().getNome());

        return ResponseEntity.ok().build();
    }

}
