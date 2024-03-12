package blackjack.domain;

import java.util.Objects;

public class Name {
    private final String value;

    public Name(String value) {
        validateNameRange(value);

        this.value = value;
    }

    private void validateNameRange(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백을 제외한 1글자 이상이어야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
