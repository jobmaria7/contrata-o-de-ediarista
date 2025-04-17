package ao.jobera.com.e_diaristas.web.mappers;


import ao.jobera.com.e_diaristas.core.models.Servico;
import ao.jobera.com.e_diaristas.web.DTOs.ServicoForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebServicoMapper {

    WebServicoMapper INSTANCE = Mappers.getMapper(WebServicoMapper.class);

    Servico toModel(ServicoForm form);

    ServicoForm toForm(Servico model);
}
