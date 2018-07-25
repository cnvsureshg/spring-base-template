package com.spring.jdbcgradle.Entity.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.spring.jdbcgradle.Entity.Skill;

import java.io.IOException;

public class SkillSerializer extends JsonSerializer<Skill> {
    @Override
    public void serialize(Skill skill, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("name");
        jsonGenerator.writeString(skill.getName());
        jsonGenerator.writeFieldName("id");
        jsonGenerator.writeNumber(skill.getId());
        jsonGenerator.writeEndObject();
    }
}
