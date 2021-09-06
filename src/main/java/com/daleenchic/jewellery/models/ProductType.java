package com.daleenchic.jewellery.models;

public enum ProductType {

	RING,
	BRACELET,
	NECKLACE,
	EARING,
	ANKLET;
	
	
	
	
//	private String type;
//        
//    private ProductType(String type) {
//		this.type = type;
//	}
//
//	@JsonCreator
//    public static ProductType convert (String type) {
//		for (ProductType types : values()) {
//			if (types.equalsIgnoreCase(type)) {
//				return types;
//			}
//		}
//		throw new IllegalArgumentException(
//				"Unknown enum type " + type + ", Allowed values are " + Arrays.toString(values()));
//	}
    
//    @JsonValue
//    public String getType() {
//        return type;
//    }
}

