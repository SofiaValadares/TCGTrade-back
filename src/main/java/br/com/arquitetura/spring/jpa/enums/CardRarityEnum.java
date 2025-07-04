package br.com.arquitetura.spring.jpa.enums;

public enum CardRarityEnum {
    // Raridades Básicas
    COMMON,             // Common (●)
    UNCOMMON,           // Uncommon (◆)
    RARE,               // Rare (★)
    DOUBLE_RARE,

    // Raras com holografia
    RARE_HOLO,          // Rare Holo
    RARE_HOLO_EX,       // Rare Holo EX
    RARE_HOLO_GX,       // Rare Holo GX
    RARE_HOLO_V,        // Rare Holo V
    RARE_HOLO_VSTAR,    // Rare Holo VSTAR
    RARE_HOLO_V_UNION,  // Rare Holo V-UNION
    RARE_HOLO_VMAX,     // Rare Holo VMAX

    // Raridades Avançadas
    V,                  // Rare V (Scarlet & Violet)
    VSTAR,              // Rare VSTAR (Scarlet & Violet)
    VMAX,               // Rare VMAX
    RADIANT,            // Rare Shiny (radiantes)

    // Ilustração Alternativa
    ILLUSTRATION_RARE,           // Illustration Rare (★◆)
    SPECIAL_ILLUSTRATION_RARE,   // Special Illustration Rare (★★◆)

    // Ultra e Secretas
    ULTRA_RARE,         // Rare Ultra
    SECRET_RARE,        // Rare Secret / Rare Rainbow / ★★★

    // Outras
    PROMO,              // Promo
    TRAINER_GALLERY,    // Galeria do Treinador (opcional)
    ACE_SPEC_RARE,
    UNKNOWN             // fallback
}
