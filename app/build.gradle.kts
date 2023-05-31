plugins {
    id("org.jetbrains.kotlin.jvm") version "1.8.10"
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

val publicationName = "konsist"

publishing {
    publications {
        create<MavenPublication>(publicationName) {
            groupId = "com.test"
            artifactId = "app"
            version = "1"
            description = "test"

            from(components["java"])
        }

        repositories {
            mavenLocal()
        }
    }
}

signing {
    // Dummy key 😛
    useInMemoryPgpKeys(
        """
            -----BEGIN PGP PRIVATE KEY BLOCK-----

            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
            =FaLS
            -----END PGP PRIVATE KEY BLOCK-----
        """.trimIndent(),
        "test",
    )

    sign(publishing.publications[publicationName])
}
