package com.espelita.lab4espelitamorris;

public class Companies {
    private String companyName,companyCountry,companyCEO,companyIndustry, companyDescription;
    private int logo;

    public Companies(int logo, String compName, String compCountry, String compCEO, String compIndustry, String compDescription){
        this.logo = logo;
        this.companyName = compName;
        this.companyCountry = compCountry;
        this.companyCEO = compCEO;
        this.companyIndustry = compIndustry;
        this.companyDescription = compDescription;
    }

    public int getLogo() {return logo;}
    public String getCompName() {return companyName;}
    public String getCompCountry() {return companyCountry;}
    public String getCompCEO() {return companyCEO;}
    public String getCompIndustry() {return  companyIndustry;}
    public String getCompDescription() {return companyDescription;}
}
