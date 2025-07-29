package com.vedant.customerRelation.beans;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interactions")
@NoArgsConstructor
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interactionId;

    private String interactionDate;
    private String interactionFeedback;
    private Integer interactionRating;
    private String interactionProduct;

    public String getInteractionFeedback() {
        return interactionFeedback;
    }

    public void setInteractionFeedback(String interactionFeedback) {
        this.interactionFeedback = interactionFeedback;
    }

    public Integer getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Integer interactionId) {
        this.interactionId = interactionId;
    }

    public String getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(String interactionDate) {
        this.interactionDate = interactionDate;
    }

    public Integer getInteractionRating() {
        return interactionRating;
    }

    public void setInteractionRating(Integer interactionRating) {
        this.interactionRating = interactionRating;
    }

    public String getInteractionProduct() {
        return interactionProduct;
    }

    public void setInteractionProduct(String interactionProduct) {
        this.interactionProduct = interactionProduct;
    }


    public Interaction(String interactinDate, String interactionFeedback, Integer interactionRating, String interactionProduct) {
        this.interactionDate = interactinDate;
        this.interactionFeedback = interactionFeedback;
        this.interactionRating = interactionRating;
        this.interactionProduct = interactionProduct;
    }

    public Interaction(){
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "id=" + interactionId +
                ", date=" + interactionDate +
                ", feedback ='" + interactionFeedback + '\'' +
                ", rating=" + interactionRating +
                ", product='" + interactionProduct + '\'' +
                '}';
    }

}
