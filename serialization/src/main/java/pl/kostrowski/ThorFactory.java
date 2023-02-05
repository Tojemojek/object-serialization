package pl.kostrowski;

import pl.kostrowski.serialization.Thor;
import pl.kostrowski.serialization.ThorSkills;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ThorFactory {

    private final Random random = new SecureRandom();
    private final Instant from = LocalDate.of(1900, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC);
    private final Instant to = LocalDate.of(2100, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC);

    public Thor createThor() {
        return Thor.builder()
                .name(generateRandomString())
                .surname(generateRandomString())
                .birthDate(generateRandomDate())
                .skills(generateRandomSkills())
                .build();
    }
    private String generateRandomString() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    private LocalDate generateRandomDate() {
        long minDay = from.toEpochMilli();
        long maxDay = to.toEpochMilli();
        long randomDay = random.nextLong(minDay, maxDay);
        return Instant.ofEpochMilli(randomDay).atZone(ZoneOffset.UTC).toLocalDate();
    }

    private BigDecimal generateRandomBigDecimal() {
        BigDecimal randomBigDecimal = BigDecimal.valueOf(random.nextDouble() * 1000);
        return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

    private List<ThorSkills> generateRandomSkills() {
        List<ThorSkills> skills = new ArrayList<>();
        int numberOfSkills = random.nextInt(10);

        for (int i=0; i<numberOfSkills; i++) {
            skills.add(ThorSkills.builder()
                    .skillName(generateRandomString())
                    .skillDescription(generateRandomString())
                    .skillDate(generateRandomDate())
                    .skillCost(generateRandomBigDecimal())
                    .build());
        }
        return skills;
    }

}
