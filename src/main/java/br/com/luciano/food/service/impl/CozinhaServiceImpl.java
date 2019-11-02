package br.com.luciano.food.service.impl;

import br.com.luciano.food.entity.CozinhaEntity;
import br.com.luciano.food.model.Cozinha;
import br.com.luciano.food.repository.CozinhaRepository;
import br.com.luciano.food.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CozinhaServiceImpl implements CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Transactional
    @Override
    public Cozinha save(Cozinha cozinha) {
        CozinhaEntity cozinhaSave = this.cozinhaRepository.save(new CozinhaEntity(cozinha));

        return cozinhaSave.toModel();
    }
}
