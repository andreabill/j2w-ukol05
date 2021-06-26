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

        if (form.getVek() > 15 && form.getVek() < 9) {
            bindingResult.rejectValue("datumNarozeni", "", "Mohou se zúčastnit jen děti od 9 do 15 let.");
            return "formular";
        }

        if (form.getZvoleneSporty().size() < 2) {
            bindingResult.rejectValue("zvoleneSporty", "", "Vyberte alespoň 2 sporty.");
            return "formular";
        }

        return new ModelAndView("formular_objednano")
                .addObject("formular", form);
                //.addObject("jmeno", form.getJmeno())
                //.addObject("prijmeni", form.getPrijmeni())
                //.addObject("datumNarozeni", form.getDatumNarozeni())
                //.addObject("pohlavi", form.getPohlavi())
                //.addObject("zvoleneSporty", form.getZvoleneSporty())
                //.addObject("turnus", form.getTurnus())
                //.addObject("email", form.getEmail())
                //.addObject("telefon", form.getTelefon());

    }
}
