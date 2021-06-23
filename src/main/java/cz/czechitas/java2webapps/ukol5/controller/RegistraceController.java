package cz.czechitas.java2webapps.ukol5.controller;

import cz.czechitas.java2webapps.ukol5.controller.entity.RegistraceForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;

/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */
@Controller
public class RegistraceController {

    @GetMapping("/")
    public ModelAndView formular() {
        ModelAndView modelAndView = new ModelAndView("formular");
        modelAndView.addObject("polozka", new RegistraceForm());
        return modelAndView;
    }

    @PostMapping("/")
    public Object form(@ModelAttribute("polozka") @Valid RegistraceForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }

        if (form.getVek() < 15 && form.getVek() > 7) {
            return "formular";
        }

        if (form.getZvoleneSporty().size() < 2) {
            return "formular";
        }

        return new ModelAndView ("formular_objednano")
            .addObject("formular", form);

    }
}
