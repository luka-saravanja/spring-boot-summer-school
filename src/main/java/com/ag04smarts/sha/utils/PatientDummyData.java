package com.ag04smarts.sha.utils;

import java.util.List;

import com.ag04smarts.sha.patient.model.PatientResource;

import static java.util.Arrays.asList;

public class PatientDummyData {

    public static List<PatientResource> loadData() {
        return asList(
            new PatientResource("Luka", "Šaravanja", "luka@email.com", "0951251251", "Osjecka ulica", "Osijek", "Hrvatska"),
            new PatientResource("Marko", "Peric", "marko@email.com", "123414523", "Zagrebacka ulica", "Zagreb", "Hrvatska"),
            new PatientResource("Petar", "Markovic", "petar@email.com", "124901894", "Splitska ulica", "Split", "Hrvatska")
        );
    }

}
