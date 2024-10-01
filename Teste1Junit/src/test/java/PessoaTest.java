import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PessoaTest {

    @Test
    public void testSomenteMulheres() {
        // Criar uma lista de pessoas de exemplo
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Ana", "F"));
        pessoas.add(new Pessoa("Carlos", "M"));
        pessoas.add(new Pessoa("Bianca", "F"));
        pessoas.add(new Pessoa("Pedro", "M"));
        pessoas.add(new Pessoa("Clara", "F"));

        // Filtrar as mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equals("F"))
                .collect(Collectors.toList());

        // Verificar se todas as pessoas filtradas são do sexo feminino
        assertTrue(mulheres.stream().allMatch(p -> p.getSexo().equals("F")),
                "A lista contém pessoas que não são mulheres!");
    }
}
