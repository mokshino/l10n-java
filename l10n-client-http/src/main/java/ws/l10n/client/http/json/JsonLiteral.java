package ws.l10n.client.http.json;

import java.io.IOException;


class JsonLiteral extends JsonValue {

    private final String value;
    private final boolean isNull;
    private final boolean isTrue;
    private final boolean isFalse;

    JsonLiteral(String value) {
        this.value = value;
        isNull = "null".equals(value);
        isTrue = "true".equals(value);
        isFalse = "false".equals(value);
    }


    void write(JsonWriter writer) throws IOException {
        writer.writeLiteral(value);
    }


    public String toString() {
        return value;
    }


    public int hashCode() {
        return value.hashCode();
    }


    public boolean isNull() {
        return isNull;
    }


    public boolean asBoolean() {
        return isNull ? super.asBoolean() : isTrue;
    }


    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        JsonLiteral other = (JsonLiteral) object;
        return value.equals(other.value);
    }

}
