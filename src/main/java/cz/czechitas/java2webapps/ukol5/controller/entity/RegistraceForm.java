package cz.czechitas.java2webapps.ukol5.controller.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;
import java.util.Objects;

public class RegistraceForm {
    @NotBlank
    private String jmeno;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getDatumNarozeni() {

        return datumNarozeni;
    }

    public void setDatumNarozeni(LocalDate datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi = pohlavi;
    }

    public EnumSet<Sport> getZvoleneSporty() {
        return zvoleneSporty;
    }

    public void setZvoleneSporty(EnumSet<Sport> zvoleneSporty) {
        this.zvoleneSporty = zvoleneSporty;
    }

    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @NotBlank
    private String prijmeni;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate datumNarozeni;
    @NotNull
    private String pohlavi;
    @NotNull
    private EnumSet<Sport> zvoleneSporty;
    @NotBlank
    private String turnus;
    @Email
    private String email;

    public RegistraceForm(String jmeno, String prijmeni, LocalDate datumNarozeni, String pohlavi,
                          EnumSet<Sport> zvoleneSporty, String turnus, String email, String telefon) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.pohlavi = pohlavi;
        this.zvoleneSporty = zvoleneSporty;
        this.turnus = turnus;
        this.email = email;
        this.telefon = telefon;
    }

    public RegistraceForm() {
    }

    private String telefon;

    public int getVek() {
        Period period = datumNarozeni.until(LocalDate.now());
        int vek = period.getYears();
        return vek;
    }
}
