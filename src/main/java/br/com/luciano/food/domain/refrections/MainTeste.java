package br.com.luciano.food.domain.refrections;

import br.com.luciano.food.api.models.Empresa;
import br.com.luciano.food.api.models.Endereco;
import com.google.common.collect.ObjectArrays;

import java.lang.reflect.Field;

public class MainTeste {

    public static void main(String[] args) throws Exception {

        Empresa original = new Empresa();
        original.setNome("Antonio");
        Endereco endereco = new Endereco();
        endereco.setCep("900000000");

        original.setEndereco(endereco);
        populateFields(original);
        Empresa copy = Empresa.valueOf(original);

        for (Field field : getAllFields(original.getClass())) {
            field.setAccessible(true);
//            if (!field.get(original).equals(field.get(copy))) {
//                System.out.println(field);
//            Object nome = field.get("nome");
//            System.out.println(field.getAnnotation());
//            }
        }

        new Reflexao()
                .refleteClasse()
                .getConstrutorPadrao()
                .invoca();

    }

    private static <T> void populateFields(T destination) throws IllegalAccessException, InstantiationException {
        for (Field field : getAllFields(destination.getClass())) {
            field.setAccessible(true);
            Class type = field.getType();
            if (type == Integer.class) {
                field.set(destination, 1);
            }
            else {
                field.set(destination, type.newInstance());
            }
        }
    }

    private static Field[] getAllFields(Class c) {

        Field[] fields = c.getDeclaredFields();
        Class superclass = c.getSuperclass();
        if (superclass == Object.class) {
            return fields;
        }
        return ObjectArrays.concat(fields, getAllFields(c.getSuperclass()), Field.class);

    }

}

class Reflexao {

    ManipuladorClasse refleteClasse() {
        return new ManipuladorClasse();
    }

}

class ManipuladorClasse {
    ManipuladorConstrutor getConstrutorPadrao() {
        return new ManipuladorConstrutor();
    }
}

class ManipuladorConstrutor {
    void invoca() {}

}
