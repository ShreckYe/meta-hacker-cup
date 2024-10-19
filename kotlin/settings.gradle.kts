plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "meta-hacker-cup-kotlin"

include("templates")
include("2024:practice-round")
include("2024:round-1")
include("2024:round-2")
