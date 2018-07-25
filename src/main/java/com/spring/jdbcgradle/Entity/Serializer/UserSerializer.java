package com.spring.jdbcgradle.Entity.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.spring.jdbcgradle.Entity.User;

import java.io.IOException;

public class UserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName("firstname");
        jsonGenerator.writeString(user.getFirstname());
        jsonGenerator.writeFieldName("id");
        jsonGenerator.writeNumber(user.getId());
        jsonGenerator.writeEndObject();
    }
}
