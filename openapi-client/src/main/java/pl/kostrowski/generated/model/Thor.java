package pl.kostrowski.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import pl.kostrowski.generated.model.ThorSkills;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Thor
 */
@lombok.Builder @lombok.NoArgsConstructor @lombok.AllArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-06T09:13:07.033175965+01:00[Europe/Warsaw]")
public class Thor implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("birthDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthDate;

  @JsonProperty("skills")
  @Valid
  private List<ThorSkills> skills = null;

  public Thor name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Thor surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */
  
  @Schema(name = "surname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Thor birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @Valid 
  @Schema(name = "birthDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Thor skills(List<ThorSkills> skills) {
    this.skills = skills;
    return this;
  }

  public Thor addSkillsItem(ThorSkills skillsItem) {
    if (this.skills == null) {
      this.skills = new ArrayList<>();
    }
    this.skills.add(skillsItem);
    return this;
  }

  /**
   * Get skills
   * @return skills
  */
  @Valid 
  @Schema(name = "skills", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<ThorSkills> getSkills() {
    return skills;
  }

  public void setSkills(List<ThorSkills> skills) {
    this.skills = skills;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Thor thor = (Thor) o;
    return Objects.equals(this.name, thor.name) &&
        Objects.equals(this.surname, thor.surname) &&
        Objects.equals(this.birthDate, thor.birthDate) &&
        Objects.equals(this.skills, thor.skills);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, birthDate, skills);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Thor {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    skills: ").append(toIndentedString(skills)).append("\n");
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

