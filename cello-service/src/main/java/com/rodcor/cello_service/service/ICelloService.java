package com.rodcor.cello_service.service;

import com.rodcor.cello_service.model.Cello;

import java.util.List;

public interface ICelloService {

    // Create a Cello
    public void saveCello(Cello cello);

    // Get a Cello
    public Cello getOneCello(String idCello);

    // Get all Cellos
    public List<Cello> getAllCellos();

    // Delete a Cello
    public void deleteCello(String idCello);

    // Edit a Cello
    public void editCello(String idCello, Cello cello);
}
