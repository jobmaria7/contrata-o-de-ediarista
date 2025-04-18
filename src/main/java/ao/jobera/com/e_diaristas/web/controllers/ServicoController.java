package ao.jobera.com.e_diaristas.web.controllers;

import ao.jobera.com.e_diaristas.core.models.enums.Icone;
import ao.jobera.com.e_diaristas.web.DTOs.FlashMessage;
import ao.jobera.com.e_diaristas.web.DTOs.ServicoForm;
import ao.jobera.com.e_diaristas.web.services.WebServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private WebServicoService service;

    //mostrando icones full
    @ModelAttribute("icones")
    public Icone[] getIcone() {
        return Icone.values();
    }

    @GetMapping
    public ModelAndView mostrarTodos() {
        var modelAndView = new ModelAndView("/admin/servicos/listar");
        modelAndView.addObject("servicos", service.buscarTodos());
        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelAndView = new ModelAndView("/admin/servicos/form");
        modelAndView.addObject("form", new ServicoForm());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("form") @Valid ServicoForm form, BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "/admin/servicos/form";
        }
        service.cadastrar(form);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço cadastrado com sucesso!"));
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var modelAndView = new ModelAndView("/admin/servicos/form");
        modelAndView.addObject("form", service.buscarPorId(id));
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @ModelAttribute("form") @Valid ServicoForm form, BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/servicos/form";
        }
        service.editar(form, id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço editado com sucesso!"));
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        service.excluir(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Serviço excluido com sucesso!"));
        return "redirect:/admin/servicos";
    }
}
