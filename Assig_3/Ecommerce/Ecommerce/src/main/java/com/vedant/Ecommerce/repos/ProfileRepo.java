package com.vedant.Ecommerce.repos;

import com.vedant.Ecommerce.beans.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {
}

