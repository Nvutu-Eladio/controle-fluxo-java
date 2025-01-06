import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OperadorServiceTest {

    @Test
    void deveRetornarTrueQuandoOperadorAutenticadoENumeroIgual() {
        // Arrange
        BuscaParticipanteDTO buscaParticipanteDTO = new BuscaParticipanteDTO();
        buscaParticipanteDTO.setAutenticadoNoCanal(true);
        buscaParticipanteDTO.setNumeroOperador("123");

        OperadorParticipanteDTO operadorParticipanteDTO = new OperadorParticipanteDTO();
        operadorParticipanteDTO.setIdOperador("123");

        // Act
        boolean resultado = verificaSeOperadorAutenticadoNoCanal(
            Optional.of(operadorParticipanteDTO), buscaParticipanteDTO);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void deveRetornarFalseQuandoOperadorNaoAutenticado() {
        // Arrange
        BuscaParticipanteDTO buscaParticipanteDTO = new BuscaParticipanteDTO();
        buscaParticipanteDTO.setAutenticadoNoCanal(false);
        buscaParticipanteDTO.setNumeroOperador("123");

        OperadorParticipanteDTO operadorParticipanteDTO = new OperadorParticipanteDTO();
        operadorParticipanteDTO.setIdOperador("123");

        // Act
        boolean resultado = verificaSeOperadorAutenticadoNoCanal(
            Optional.of(operadorParticipanteDTO), buscaParticipanteDTO);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void deveRetornarFalseQuandoOperadorNaoPresente() {
        // Arrange
        BuscaParticipanteDTO buscaParticipanteDTO = new BuscaParticipanteDTO();
        buscaParticipanteDTO.setAutenticadoNoCanal(true);
        buscaParticipanteDTO.setNumeroOperador("123");

        // Act
        boolean resultado = verificaSeOperadorAutenticadoNoCanal(
            Optional.empty(), buscaParticipanteDTO);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void deveRetornarFalseQuandoNumeroOperadorNaoIgual() {
        // Arrange
        BuscaParticipanteDTO buscaParticipanteDTO = new BuscaParticipanteDTO();
        buscaParticipanteDTO.setAutenticadoNoCanal(true);
        buscaParticipanteDTO.setNumeroOperador("123");

        OperadorParticipanteDTO operadorParticipanteDTO = new OperadorParticipanteDTO();
        operadorParticipanteDTO.setIdOperador("456");

        // Act
        boolean resultado = verificaSeOperadorAutenticadoNoCanal(
            Optional.of(operadorParticipanteDTO), buscaParticipanteDTO);

        // Assert
        assertFalse(resultado);
    }

    // Método auxiliar para simular o método que está sendo testado
    private boolean verificaSeOperadorAutenticadoNoCanal(
            Optional<OperadorParticipanteDTO> operadorParticipante,
            BuscaParticipanteDTO buscaParticipanteDTO) {
        return buscaParticipanteDTO.isAutenticadoNoCanal() &&
               operadorParticipante.isPresent() &&
               operadorParticipante.get().getIdOperador().equalsIgnoreCase(buscaParticipanteDTO.getNumeroOperador());
    }
}
