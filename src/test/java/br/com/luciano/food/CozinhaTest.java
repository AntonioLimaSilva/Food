package br.com.luciano.food;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.luciano.food.api.models.Cozinha;
import br.com.luciano.food.api.models.Servico;
import br.com.luciano.food.domain.services.CozinhaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CozinhaTest {

    @Autowired
    private CozinhaService cozinhaService;

    @Before
    public void init() {
        System.out.println("Iniciando....");
    }

    @Test
    public void shoudSaveCozinha() {
        Cozinha cozinha = new Cozinha();
        cozinha.setName("Japoneza");
        cozinha.setServico(Servico.GOURMET);

        cozinha = cozinhaService.save(cozinha);

        assertThat(cozinha).isNotNull();
    }

    @Test
    public void test2() {
        System.out.println("Test 1");
    }

}
