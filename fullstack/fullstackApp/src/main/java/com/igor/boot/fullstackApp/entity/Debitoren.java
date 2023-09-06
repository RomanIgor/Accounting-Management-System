package com.igor.boot.fullstackApp.entity;



import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "debitoren")
public class Debitoren {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firma")
    private String firma;
    @Column(name = "rechnung_nummer")
    private String rechnungNummer;

    @Column (name = "rechnung_datum")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rechnungDatum;
    @Column(name = "frist")
    private String frist;

    @Column(name = "art_rechnung")
    private String artRechnung;

    @Column(name = "betrag")
    private BigDecimal betrag;

    @Column(name = "nächste_erinnerung")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date naechsteErrinerung;

    @Column(name = "kommentare")
    private String kommentare;

    public Debitoren() {
    }

    public Debitoren(
            int id, String firma, String rechnungNummer,
            Date rechnungDatum, String frist, String artRechnung,
            BigDecimal betrag, Date naechsteErrinerung, String kommentare) {

        this.id = id;
        this.firma = firma;
        this.rechnungNummer = rechnungNummer;
        this.rechnungDatum = rechnungDatum;
        this.frist = frist;
        this.artRechnung = artRechnung;
        this.betrag = betrag;
        this.naechsteErrinerung = naechsteErrinerung;
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

    public String getRechnungNummer() {
        return rechnungNummer;
    }

    public void setRechnungNummer(String rechnungNummer) {
        this.rechnungNummer = rechnungNummer;
    }

    public Date getRechnungDatum() {
        return rechnungDatum;
    }

    public void setRechnungDatum(Date rechnungDatum) {
        this.rechnungDatum = rechnungDatum;
    }

    public String getFrist() {
        return frist;
    }

    public void setFrist(String frist) {
        this.frist = frist;
    }

    public String getArtRechnung() {
        return artRechnung;
    }

    public void setArtRechnung(String artRechnung) {
        this.artRechnung = artRechnung;
    }

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    public Date getNaechsteErrinerung() {
        return naechsteErrinerung;
    }

    public void setNaechsteErrinerung(Date nächsteErrinerung) {
        this.naechsteErrinerung = nächsteErrinerung;
    }

    public String getKommentare() {
        return kommentare;
    }

    public void setKommentare(String kommentare) {
        this.kommentare = kommentare;
    }
}
