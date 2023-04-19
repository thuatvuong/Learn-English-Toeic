package com.webtoeic.jpautil;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import com.webtoeic.entities.PartToeic;

@Convert
public class PartToeicTypeConverter implements AttributeConverter<PartToeic, Integer> {

	@Override
	public Integer convertToDatabaseColumn(PartToeic part) {
		return part.getValue();
	}

	@Override
	public PartToeic convertToEntityAttribute(Integer value) {
		for (PartToeic type : PartToeic.values()) {
			if (type.getValue() == value) {
				return type;
			}
		}
		throw new IllegalArgumentException(" Illegal tagType value exception.");
	}

}
