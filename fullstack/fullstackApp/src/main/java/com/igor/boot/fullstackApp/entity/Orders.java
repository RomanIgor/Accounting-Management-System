package com.igor.boot.fullstackApp.entity;


import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "projekt_nummer")
    private String projektNummer;
    @Column(name = "bestelldatum")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bestellDatum;
    @Column(name = "firma")
    private String firma;
    @Column(name = "land")
    private String land;
    @Column(name = "bestell_nummer")
    private String bestellNummer;
    @Column(name = "angebot_nummer")
    private String angebotNummer;
    @Column(name = "leistungsbeschreibung")
    private String leistungsBeschreibung;
    @Column(name = "pm")
    private String projektManager;
    @Column(name = "preis_netto")
    private BigDecimal preisNetto;
    @Column(name = "zahlungsbedinungen")
    private String zahlungsBedinungen;
    @Column(name = "erstellte_brutto")
    private BigDecimal erstellteBrutto;
    @Column(name = "rechnung_nummer")
    private String rechnungNummer;
    @Column(name = "rechnung_datum")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rechnungDatum;
    @Column(name = "kommentare")
    private String kommentare;

    public Orders() {
    }

    public Orders(
            int id, String projektNummer, Date bestellDatum, String firma,
            String land, String bestellNummer,
            String angebotNummer, String leistungsBeschreibung,
            String projektManager, BigDecimal preisNetto,
            String zahlungsBedinungen, BigDecimal erstellteBrutto,
            String rechnungNummer, Date rechnungDatum, String kommentare) {
        this.id = id;
        this.projektNummer = projektNummer;
        this.bestellDatum = bestellDatum;
        this.firma = firma;
        this.land = land;
        this.bestellNummer = bestellNummer;
        this.angebotNummer = angebotNummer;
        this.leistungsBeschreibung = leistungsBeschreibung;
        this.projektManager = projektManager;
        this.preisNetto = preisNetto;
        this.zahlungsBedinungen = zahlungsBedinungen;
        this.erstellteBrutto = erstellteBrutto;
        this.rechnungNummer = rechnungNummer;
        this.rechnungDatum = rechnungDatum;
        this.kommentare = kommentare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjektNummer() {
        return projektNummer;
    }

    public void setProjektNummer(String projektNummer) {
        this.projektNummer = projektNummer;
    }

    public Date getBestellDatum() {
        return bestellDatum;
    }

    public void setBestellDatum(Date bestellDatum) {
        this.bestellDatum = bestellDatum;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getBestellNummer() {
        return bestellNummer;
    }

    public void setBestellNummer(String bestellNummer) {
        this.bestellNummer = bestellNummer;
    }

    public String getAngebotNummer() {
        return angebotNummer;
    }

    public void setAngebotNummer(String angebotNummer) {
        this.angebotNummer = angebotNummer;
    }

    public String getLeistungsBeschreibung() {
        return leistungsBeschreibung;
    }

    public void setLeistungsBeschreibung(String leistungsBeschreibung) {
        this.leistungsBeschreibung = leistungsBeschreibung;
    }

    public String getProjektManager() {
        return projektManager;
    }

    public void setProjektManager(String projektManager) {
        this.projektManager = projektManager;
    }

    public BigDecimal getPreisNetto() {
        return preisNetto;
    }

    public void setPreisNetto(BigDecimal preisNetto) {
        this.preisNetto = preisNetto;
    }

    public String getZahlungsBedinungen() {
        return zahlungsBedinungen;
    }

    public void setZahlungsBedinungen(String zahlungsBedinungen) {
        this.zahlungsBedinungen = zahlungsBedinungen;
    }

    public BigDecimal getErstellteBrutto() {
        return erstellteBrutto;
    }

    public void setErstellteBrutto(BigDecimal erstellteBrutto) {
        this.erstellteBrutto = erstellteBrutto;
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

    public String getKommentare() {
        return kommentare;
    }

    public void setKommentare(String kommentare) {
        this.kommentare = kommentare;
    }
}
