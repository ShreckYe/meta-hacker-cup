plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "codeforces-kotlin"

include("kotlin-heroes:practice-11")
include("test")
