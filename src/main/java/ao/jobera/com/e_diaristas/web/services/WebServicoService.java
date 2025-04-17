package ao.jobera.com.e_diaristas.web.services;import ao.jobera.com.e_diaristas.core.repository.ServicoRepository;import ao.jobera.com.e_diaristas.core.exceptions.ServicoNaoEncontradoException;import ao.jobera.com.e_diaristas.core.models.Servico;import ao.jobera.com.e_diaristas.web.DTOs.ServicoForm;import ao.jobera.com.e_diaristas.web.mappers.WebServicoMapper;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.List;@Servicepublic class WebServicoService {    @Autowired    private ServicoRepository repository;    @Autowired    private WebServicoMapper mapper;    public List<Servico> buscarTodos(){        return repository.findAll();    }    public Servico cadastrar(ServicoForm form){        var model = mapper.toModel(form);        return repository.save(model);    }    public Servico buscarPorId(Long id){        var servicoEncontrado = repository.findById(id);        if (servicoEncontrado.isPresent()){            return servicoEncontrado.get();        }        var message = String.format("O servico com ID %d não encontrado!", id);        throw new ServicoNaoEncontradoException(message);    }    public Servico editar(ServicoForm form, Long id){        var servicoEncontrado = buscarPorId(id);        var model = mapper.toModel(form);        model.setId(servicoEncontrado.getId());        return repository.save(model);    }    public  void excluir(Long id){        var servicoEncontrado = buscarPorId(id);        repository.delete(servicoEncontrado);    }}