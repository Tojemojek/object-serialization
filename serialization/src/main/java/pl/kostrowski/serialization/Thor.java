package pl.kostrowski.serialization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Thor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private List<ThorSkills> skills;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Thor thor = (Thor) o;

        if (!Objects.equals(name, thor.name))
            return false;
        if (!Objects.equals(surname, thor.surname))
            return false;
        if (!Objects.equals(birthDate, thor.birthDate))
            return false;
        return  CollectionUtils.isEqualCollection(skills, thor.skills);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }
}