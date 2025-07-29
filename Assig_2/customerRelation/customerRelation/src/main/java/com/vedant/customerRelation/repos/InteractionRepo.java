package com.vedant.customerRelation.repos;

import com.vedant.customerRelation.beans.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepo extends JpaRepository<Interaction, Integer> {

    public List<Interaction> findByInteractionProduct(String interactionProduct);
    public List<Interaction>  findByInteractionDateBetween(String startDate, String endDate);
    public List<Interaction>  findByInteractionRating(Integer interactionRating);

}
