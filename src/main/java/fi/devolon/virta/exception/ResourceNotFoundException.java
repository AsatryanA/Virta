package fi.devolon.virta.exception;

import jakarta.persistence.EntityNotFoundException;

public class ResourceNotFoundException extends EntityNotFoundException {
    public ResourceNotFoundException(Long id) {
        super(id.toString());
    }
}
