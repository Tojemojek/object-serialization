package pl.kostrowski.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ThorSkills
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-05T17:16:28.937299049+01:00[Europe/Warsaw]")
public class ThorSkills implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("skillName")
  private String skillName;

  @JsonProperty("skillDescription")
  private String skillDescription;

  @JsonProperty("skillDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate skillDate;

  @JsonProperty("skillCost")
  private BigDecimal skillCost;

  public ThorSkills skillName(String skillName) {
    this.skillName = skillName;
    return this;
  }

  /**
   * Get skillName
   * @return skillName
  */
  
  @Schema(name = "skillName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSkillName() {
    return skillName;
  }

  public void setSkillName(String skillName) {
    this.skillName = skillName;
  }

  public ThorSkills skillDescription(String skillDescription) {
    this.skillDescription = skillDescription;
    return this;
  }

  /**
   * Get skillDescription
   * @return skillDescription
  */
  
  @Schema(name = "skillDescription", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSkillDescription() {
    return skillDescription;
  }

  public void setSkillDescription(String skillDescription) {
    this.skillDescription = skillDescription;
  }

  public ThorSkills skillDate(LocalDate skillDate) {
    this.skillDate = skillDate;
    return this;
  }

  /**
   * Get skillDate
   * @return skillDate
  */
  @Valid 
  @Schema(name = "skillDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public LocalDate getSkillDate() {
    return skillDate;
  }

  public void setSkillDate(LocalDate skillDate) {
    this.skillDate = skillDate;
  }

  public ThorSkills skillCost(BigDecimal skillCost) {
    this.skillCost = skillCost;
    return this;
  }

  /**
   * Get skillCost
   * @return skillCost
  */
  @Valid 
  @Schema(name = "skillCost", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public BigDecimal getSkillCost() {
    return skillCost;
  }

  public void setSkillCost(BigDecimal skillCost) {
    this.skillCost = skillCost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ThorSkills thorSkills = (ThorSkills) o;
    return Objects.equals(this.skillName, thorSkills.skillName) &&
        Objects.equals(this.skillDescription, thorSkills.skillDescription) &&
        Objects.equals(this.skillDate, thorSkills.skillDate) &&
        Objects.equals(this.skillCost, thorSkills.skillCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(skillName, skillDescription, skillDate, skillCost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ThorSkills {\n");
    sb.append("    skillName: ").append(toIndentedString(skillName)).append("\n");
    sb.append("    skillDescription: ").append(toIndentedString(skillDescription)).append("\n");
    sb.append("    skillDate: ").append(toIndentedString(skillDate)).append("\n");
    sb.append("    skillCost: ").append(toIndentedString(skillCost)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

