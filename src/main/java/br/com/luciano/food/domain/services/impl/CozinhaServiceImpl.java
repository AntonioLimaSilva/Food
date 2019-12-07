package br.com.luciano.food.domain.services.impl;

import br.com.luciano.food.domain.entities.CozinhaEntity;
import br.com.luciano.food.api.models.Cozinha;
import br.com.luciano.food.api.models.Servico;
import br.com.luciano.food.domain.repositories.CozinhaRepository;
import br.com.luciano.food.domain.services.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.*;

@Service
public class CozinhaServiceImpl implements CozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private ApplicationContext ctx;

    @Transactional
    @Override
    public Cozinha save(Cozinha cozinha) {
        CozinhaEntity cozinhaSave = this.cozinhaRepository.save(new CozinhaEntity(cozinha));

        return cozinhaSave.toModel();
    }

    public Cozinha execute(Cozinha cozinha) {
        this.save(cozinha);

        ExecutorService service = Executors.newSingleThreadExecutor();

        Optional<Servico> optionalServico = this.findServico(cozinha.getServico());

        if(optionalServico.isPresent()) {
            TaskService task = new TaskService(ctx, optionalServico.get(), 1L);
            Future<Cozinha> future = service.submit(task);
            try {
                Cozinha cozinha1 = future.get(60, TimeUnit.SECONDS);
                System.out.println(">>>> Tarefa futura " + cozinha1.getName());
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        }

        System.out.println(">>> Fim");

        return cozinha;
    }

    private Optional<Servico> findServico(Servico servico) {
        return this.cozinhaRepository.findByServico(servico)
                .stream().map(CozinhaEntity::getServico).findAny();
    }
}
