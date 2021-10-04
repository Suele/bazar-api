package com.bazar.api.bazar.repositories;

import com.bazar.api.bazar.entities.ItemsSale;
import com.bazar.api.bazar.entities.ItemsSaleKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsSaleRepository extends JpaRepository<ItemsSale, ItemsSaleKey> {
}
