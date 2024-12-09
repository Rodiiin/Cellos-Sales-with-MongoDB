package com.rodcor.cello_service.service;


import com.rodcor.cello_service.model.Cello;
import com.rodcor.cello_service.repository.ICelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelloService implements ICelloService {

    @Autowired
    private ICelloRepository celloRepository;

    // Create a Cello
    @Override
    public void saveCello(Cello cello) {
        // Save the provided Cello object to the MongoDB collection
        celloRepository.save(cello);
    }

    // Get a Cello by ID
    @Override
    public Cello getOneCello(String idCello) {
        // Find the Cello by its ID, return it if found, otherwise return null
        Optional<Cello> optionalCello = celloRepository.findById(idCello);
        return optionalCello.orElse(null); }

    // Get all Cellos
    @Override
    public List<Cello> getAllCellos() {
        // Retrieve all Cello objects from the MongoDB collection
        return celloRepository.findAll();
    }

    // Delete a Cello by ID
    @Override
    public void deleteCello(String idCello) {
        // Delete the Cello with the provided ID from the MongoDB collection
        celloRepository.deleteById(idCello);
    }

    @Override
    public void editCello(String idCello, Cello cello) {
        // Check if a Cello with the provided ID exists
        if (celloRepository.existsById(idCello)) {
            // Retrieve the existing Cello document
            Cello existingCello = celloRepository.findById(idCello)
                    .orElseThrow(() -> new RuntimeException("Cello not found"));

            // Update the existing Cello document with the new values
            existingCello.setCelloName(cello.getCelloName());
            existingCello.setCelloSize(cello.getCelloSize());
            existingCello.setCelloCost(cello.getCelloCost());

            // Save the updated Cello object to the MongoDB collection
            celloRepository.save(existingCello);
        } else {
            throw new RuntimeException("Cello with ID " + idCello + " not found");
        }
    }

}

