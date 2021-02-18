plugins {
    id("org.jlleitschuh.disclosure.automated.kotlin-library-conventions")
}

dependencies {
    implementation(project(":driver"))
    implementation("org.fluentlenium:fluentlenium-core")
}
