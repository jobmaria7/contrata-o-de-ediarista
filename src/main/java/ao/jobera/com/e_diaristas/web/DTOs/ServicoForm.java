package ao.jobera.com.e_diaristas.web.DTOs;

import ao.jobera.com.e_diaristas.core.models.enums.Icone;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoForm {

    @NotNull
    @Size(min = 5, max = 50, message = "O nome deve ter entre 5 e 50 caracteres")
    private String nome;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private BigDecimal valorMinimo;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private Integer qtdHoras;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    @Max(100)
    private BigDecimal porcentagemComissao;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private Integer horasQuarto;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private BigDecimal valorQuarto;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private Integer horasSala;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private BigDecimal valorSala;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private Integer horasBanheiro;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private BigDecimal valorBanheiro;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private Integer horasCozinha;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private BigDecimal valorCozinha;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private Integer horasQuintal;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private BigDecimal valorQuintal;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private Integer horasOutros;

    @NotNull(message = "Este campo é obrigatório")
    @PositiveOrZero
    private BigDecimal valorOutros;

    @NotNull(message = "O ícone é obrigatório")
    private Icone icone;

    @NotNull(message = "Este campo é obrigatório")
    @Positive
    private Integer posicao;
}
