package pl.kostrowski.kryo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ThorSkills {
    private String skillName;
    private String skillDescription;
    private LocalDate skillDate;
    private BigDecimal skillCost;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ThorSkills that = (ThorSkills) o;

        if (!Objects.equals(skillName, that.skillName))
            return false;
        if (!Objects.equals(skillDescription, that.skillDescription))
            return false;
        if (!Objects.equals(skillDate, that.skillDate))
            return false;
        return Objects.equals(skillCost, that.skillCost);
    }

    @Override
    public int hashCode() {
        int result = skillName != null ? skillName.hashCode() : 0;
        result = 31 * result + (skillDescription != null ? skillDescription.hashCode() : 0);
        result = 31 * result + (skillDate != null ? skillDate.hashCode() : 0);
        result = 31 * result + (skillCost != null ? skillCost.hashCode() : 0);
        return result;
    }
}