package br.com.luciano.food.domain.service;

import br.com.luciano.food.domain.model.Cozinha;
import br.com.luciano.food.domain.model.ServiceCozinha;
import org.springframework.stereotype.Service;

@Service
public class CozinhaService {

    public void salvar(ServiceCozinha service, Cozinha cozinha) {
        switch (service) {
            case GOURMET:
                System.out.println("regra gourmet..." + cozinha);
                break;
            case VEGETARIANA:
                System.out.println("regra vegetariano" + cozinha);
                break;
        }
    }


}
