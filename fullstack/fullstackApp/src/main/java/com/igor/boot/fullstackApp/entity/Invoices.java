package com.igor.boot.fullstackApp.entity;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

@Entity
@Table(name = "invoices")
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;
    @Column(name = "firma")
    private String firma;
    @Column(name = "rechnungs_nummer")
    private String rechnungsNummer;
    @Column(name = "rechnungs_datum")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rechnungsDatum;
    @Column(name = "frist")
    private String frist;
    @Column(name = "bestelldatum")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bestellDatum;
    @Column(name = "gesamt_preis_laut_bestellung")
    private BigDecimal gesamtPreisLautBestellung;
    @Column(name = "rechnung_art")
    private String rechnungsart;
    @Column(name = "alpha_nr")
    private String alphaNr;
    @Column(name = "konto")
    private String konto;
    @Column(name = "re_betrag")
    private BigDecimal rechnungBetrag;
    @Column(name = "bezahlt")
    private BigDecimal bezahlt;
    @Column(name = "kommentare")
    private String kommentare;

    public Invoices() {
    }

    public Invoices(
            int id, String firma, String rechnungsNummer,
            Date rechnungsDatum, String frist, Date bestellDatum,
            BigDecimal gesamtPreisLautBestellung, String rechnungsart,
            String alphaNr, String konto, BigDecimal rechnungBetrag,
            BigDecimal bezahlt, String kommentare) {
        this.id = id;
        this.firma = firma;
        this.rechnungsNummer = rechnungsNummer;
        this.rechnungsDatum = rechnungsDatum;
        this.frist = frist;
        this.bestellDatum = bestellDatum;
        this.gesamtPreisLautBestellung = gesamtPreisLautBestellung;
        this.rechnungsart = rechnungsart;
        this.alphaNr = alphaNr;
        this.konto = konto;
        this.rechnungBetrag = rechnungBetrag;
        this.bezahlt = bezahlt;
        this.kommentare = kommentare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getRechnungsNummer() {
        return rechnungsNummer;
    }

    public void setRechnungsNummer(String rechnungsNummer) {
        this.rechnungsNummer = rechnungsNummer;
    }

    public Date getRechnungsDatum() {
        return rechnungsDatum;
    }

    public void setRechnungsDatum(Date rechnungsDatum) {
        this.rechnungsDatum = rechnungsDatum;
    }

    public String getFrist() {
        return frist;
    }

    public void setFrist(String frist) {
        this.frist = frist;
    }

    public Date getBestellDatum() {
        return bestellDatum;
    }

    public void setBestellDatum(Date bestellDatum) {
        this.bestellDatum = bestellDatum;
    }

    public BigDecimal getGesamtPreisLautBestellung() {
        return gesamtPreisLautBestellung;
    }

    public void setGesamtPreisLautBestellung(BigDecimal gesamtPreisLautBestellung) {
        this.gesamtPreisLautBestellung = gesamtPreisLautBestellung;
    }

    public String getRechnungsart() {
        return rechnungsart;
    }

    public void setRechnungsart(String rechnungsart) {
        this.rechnungsart = rechnungsart;
    }

    public String getAlphaNr() {
        return alphaNr;
    }

    public void setAlphaNr(String alphaNr) {
        this.alphaNr = alphaNr;
    }

    public String getKonto() {
        return konto;
    }

    public void setKonto(String konto) {
        this.konto = konto;
    }

    public BigDecimal getRechnungBetrag() {
        return rechnungBetrag;
    }

    public void setRechnungBetrag(BigDecimal rechnungBetrag) {
        this.rechnungBetrag = rechnungBetrag;
    }

    public BigDecimal getBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(BigDecimal bezahlt) {
        this.bezahlt = bezahlt;
    }

    public String getKommentare() {
        return kommentare;
    }

    public void setKommentare(String kommentare) {
        this.kommentare = kommentare;
    }
}
